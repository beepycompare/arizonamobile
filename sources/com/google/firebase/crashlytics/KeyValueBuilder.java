package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.CustomKeysAndValues;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyValueBuilder.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0010¢\u0006\u0002\u0010\u0005B\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0011J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0013J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0014J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/crashlytics/KeyValueBuilder;", "", "crashlytics", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;)V", "()V", "builder", "Lcom/google/firebase/crashlytics/CustomKeysAndValues$Builder;", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;Lcom/google/firebase/crashlytics/CustomKeysAndValues$Builder;)V", "build", "Lcom/google/firebase/crashlytics/CustomKeysAndValues;", "build$com_google_firebase_firebase_crashlytics", "key", "", "", "value", "", "", "", "", "", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KeyValueBuilder {
    private final CustomKeysAndValues.Builder builder;
    private final FirebaseCrashlytics crashlytics;

    private KeyValueBuilder(FirebaseCrashlytics firebaseCrashlytics, CustomKeysAndValues.Builder builder) {
        this.crashlytics = firebaseCrashlytics;
        this.builder = builder;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Do not construct this directly. Use `setCustomKeys` instead. To be removed in the next major release.")
    public KeyValueBuilder(FirebaseCrashlytics crashlytics) {
        this(crashlytics, new CustomKeysAndValues.Builder());
        Intrinsics.checkNotNullParameter(crashlytics, "crashlytics");
    }

    public KeyValueBuilder() {
        this(null, new CustomKeysAndValues.Builder());
    }

    public final CustomKeysAndValues build$com_google_firebase_firebase_crashlytics() {
        CustomKeysAndValues build = this.builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final void key(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            Intrinsics.checkNotNullExpressionValue(this.builder.putBoolean(key, z), "builder.putBoolean(key, value)");
            return;
        }
        firebaseCrashlytics.setCustomKey(key, z);
        Unit unit = Unit.INSTANCE;
    }

    public final void key(String key, double d) {
        Intrinsics.checkNotNullParameter(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            Intrinsics.checkNotNullExpressionValue(this.builder.putDouble(key, d), "builder.putDouble(key, value)");
            return;
        }
        firebaseCrashlytics.setCustomKey(key, d);
        Unit unit = Unit.INSTANCE;
    }

    public final void key(String key, float f) {
        Intrinsics.checkNotNullParameter(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            Intrinsics.checkNotNullExpressionValue(this.builder.putFloat(key, f), "builder.putFloat(key, value)");
            return;
        }
        firebaseCrashlytics.setCustomKey(key, f);
        Unit unit = Unit.INSTANCE;
    }

    public final void key(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            Intrinsics.checkNotNullExpressionValue(this.builder.putInt(key, i), "builder.putInt(key, value)");
            return;
        }
        firebaseCrashlytics.setCustomKey(key, i);
        Unit unit = Unit.INSTANCE;
    }

    public final void key(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            Intrinsics.checkNotNullExpressionValue(this.builder.putLong(key, j), "builder.putLong(key, value)");
            return;
        }
        firebaseCrashlytics.setCustomKey(key, j);
        Unit unit = Unit.INSTANCE;
    }

    public final void key(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            Intrinsics.checkNotNullExpressionValue(this.builder.putString(key, value), "builder.putString(key, value)");
            return;
        }
        firebaseCrashlytics.setCustomKey(key, value);
        Unit unit = Unit.INSTANCE;
    }
}
