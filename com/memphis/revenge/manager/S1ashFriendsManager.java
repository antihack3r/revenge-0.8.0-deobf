//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.manager;

import java.util.function.*;
import com.google.gson.*;
import java.util.*;

public class S1ashFriendsManager
{
    public static final Set<String> FRIENDS;
    
    private S1ashFriendsManager() {
    }
    
    public static boolean isFriend(final String name) {
        return S1ashFriendsManager.FRIENDS.stream().anyMatch(f -> f.equalsIgnoreCase(name));
    }
    
    public static boolean addFriend(final String name) {
        return !S1ashFriendsManager.FRIENDS.contains(name) && S1ashFriendsManager.FRIENDS.add(name);
    }
    
    public static boolean removeFriend(final String name) {
        return S1ashFriendsManager.FRIENDS.contains(name) && S1ashFriendsManager.FRIENDS.remove(name);
    }
    
    public static void removeAllFriends() {
        S1ashFriendsManager.FRIENDS.clear();
    }
    
    public static JsonArray serialize() {
        final JsonArray result = new JsonArray();
        S1ashFriendsManager.FRIENDS.forEach(result::add);
        return result;
    }
    
    public static void deserialize(final JsonArray array) {
        array.forEach(f -> S1ashFriendsManager.FRIENDS.add(f.getAsString()));
    }
    
    static {
        (FRIENDS = new HashSet<String>()).add("memphis");
        S1ashFriendsManager.FRIENDS.add("s1ash");
        S1ashFriendsManager.FRIENDS.add("Dove");
        S1ashFriendsManager.FRIENDS.add("Sudmarinz");
        S1ashFriendsManager.FRIENDS.add("BlackBro4");
    }
}
