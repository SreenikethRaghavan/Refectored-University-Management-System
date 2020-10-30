package com.softeng306.managers;

import com.softeng306.domain.course.group.Group;
import com.softeng306.enums.GroupType;

import java.util.List;

public interface IGroupMgr {
    /**
     * Checks whether the inputted department is valid.
     *
     * @param groupType The type of this group.
     * @param groups    A list of a certain type of groups in a course.
     * @return the name of the group chosen by the user.
     */
    Group printGroupWithVacancyInfo(GroupType groupType, List<Group> groups);
}
