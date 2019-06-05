package com.example.per2.twitchapp;

final public class Links {
    final private String self;
    final private String next;

    public Links(String self, String next) {
        this.self = self;
        this.next = next;
    }

    public String getSelf() {
        return self;
    }

    public String getNext() {
        return next;
    }
}
