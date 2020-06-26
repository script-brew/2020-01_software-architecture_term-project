package com.rss.util;

import com.rss.entity.Facility;
import com.rss.entity.User;

public class SystemStatus {
    private static User currentUser;
    private static Facility currentFacility;

    public static User getUser() {
        return currentUser;
    }

    public static void setUser(User user) {
        currentUser = user;
    }

    public static Facility getFacility() {return currentFacility;}

    public static void setFacility(Facility facility) { currentFacility = facility;}
}
