package com.julianotorquato07.tasklist.common.message;


public enum TypeMessage {
    WARNING("warning"), ERROR("error"), SUCCESS("success");

    String type;

    TypeMessage(String type) {
        this.type = type;
    }

    public String get() {
        return this.type;
    }
    
}
