package com.softeng306.domain.course;

import com.softeng306.domain.course.group.IGroup;
import com.softeng306.domain.course.group.Group;
import com.softeng306.domain.exceptions.ProfessorNotFoundException;
import com.softeng306.domain.professor.IProfessor;
import com.softeng306.enums.CourseType;
import com.softeng306.enums.Department;
import com.softeng306.enums.GroupType;
import com.softeng306.managers.IProfessorMgr;
import com.softeng306.managers.ProfessorMgr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Concrete implementation of course builder.
 * Used to build a new academic course.
 * Provides implementations of methods to set properties of a new course.
 * This class implements {@code ICourseBuilder}.
 */
public class CourseBuilder implements ICourseBuilder {
    private ICourse course;

    /**
     * Constructor, initialises the new course.
     */
    public CourseBuilder() {
        course = new Course();
    }

    @Override
    public void setCourseID(String id) {
        course.setCourseId(id);
    }

    @Override
    public void setCourseName(String name) {
        course.setName(name);
    }

    @Override
    public void setCourseCoordinator(String profID) throws ProfessorNotFoundException {
        IProfessorMgr profMgr = ProfessorMgr.getInstance();
        //Guaranteed at this point that the ID is valid
        IProfessor profInCharge = profMgr.getProfessorFromID(profID);
        course.setCourseCoordinator(profInCharge);
    }

    @Override
    public void setCourseCapacity(int courseCapacity) {
        course.setCapacity(courseCapacity);
        course.setVacancies(courseCapacity);
    }

    @Override
    public void setLectureGroups(Map<String, Double> lectureGroups) {
        List<IGroup> newLectureGroups = convertMapToGroups(lectureGroups, GroupType.LECTURE_GROUP);

        course.setLectureGroups(newLectureGroups);
    }

    @Override
    public void setTutorialGroups(Map<String, Double> tutorialGroups) {
        List<IGroup> newTutorialGroups = convertMapToGroups(tutorialGroups, GroupType.TUTORIAL_GROUP);

        course.setTutorialGroups(newTutorialGroups);
    }

    @Override
    public void setLabGroups(Map<String, Double> labGroups) {
        List<IGroup> newLabGroups = convertMapToGroups(labGroups, GroupType.LAB_GROUP);

        course.setLabGroups(newLabGroups);
    }

    /**
     * Local method used to convert a map of primitive information to new group instances.
     *
     * @param groups The information for each new group.
     * @param type   The type of group to make.
     * @return List of new groups.
     */
    private List<IGroup> convertMapToGroups(Map<String, Double> groups, GroupType type) {
        List<IGroup> newGroups = new ArrayList<>();

        //Go through each item in the given map, and make a new group from the data.
        for (String groupName : groups.keySet()) {
            IGroup group = new Group(groupName, groups.get(groupName).intValue(), groups.get(groupName).intValue(), type);
            newGroups.add(group);
        }

        return newGroups;
    }

    @Override
    public void setAcademicUnits(int academicUnits) {
        course.setAcademicUnits(academicUnits);
    }

    @Override
    public void setCourseDepartment(String department) {
        course.setDepartment(Department.valueOf(department));
    }

    @Override
    public void setCourseType(String type) {
        course.setType(CourseType.valueOf(type));
    }

    @Override
    public void setLecWeeklyHour(int lecWeeklyHour) {
        course.setLectureHoursPerWeek(lecWeeklyHour);
    }

    @Override
    public void setTutWeeklyHour(int tutWeeklyHour) {
        course.setTutorialHoursPerWeek(tutWeeklyHour);
    }

    @Override
    public void setLabWeeklyHour(int labWeeklyHour) {
        course.setLabHoursPerWeek(labWeeklyHour);
    }

    @Override
    public ICourse build() {
        return course;
    }

}
