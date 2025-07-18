package com.google.firebase.installations;

import com.google.firebase.FirebaseException;
/* loaded from: classes4.dex */
public class FirebaseInstallationsException extends FirebaseException {
    private final Status status;

    /* loaded from: classes4.dex */
    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public FirebaseInstallationsException(Status status) {
        this.status = status;
    }

    public FirebaseInstallationsException(String str, Status status) {
        super(str);
        this.status = status;
    }

    public FirebaseInstallationsException(String str, Status status, Throwable th) {
        super(str, th);
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }
}
