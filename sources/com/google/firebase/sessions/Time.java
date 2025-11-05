package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: TimeProvider.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B3\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0004\u0010\fJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006("}, d2 = {"Lcom/google/firebase/sessions/Time;", "", "ms", "", "<init>", "(J)V", "seen0", "", "us", "seconds", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMs", "()J", "getUs", "getSeconds", "minus", "Lkotlin/time/Duration;", "time", "minus-5sfh64U", "(Lcom/google/firebase/sessions/Time;)J", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_firebase_sessions", "$serializer", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final class Time {
    public static final Companion Companion = new Companion(null);
    private final long ms;
    private final long seconds;
    private final long us;

    public static /* synthetic */ Time copy$default(Time time, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = time.ms;
        }
        return time.copy(j);
    }

    public final long component1() {
        return this.ms;
    }

    public final Time copy(long j) {
        return new Time(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Time) && this.ms == ((Time) obj).ms;
    }

    public int hashCode() {
        return Long.hashCode(this.ms);
    }

    public String toString() {
        return "Time(ms=" + this.ms + ')';
    }

    /* compiled from: TimeProvider.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/Time$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/sessions/Time;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Time> serializer() {
            return Time$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Time(int i, long j, long j2, long j3, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, Time$$serializer.INSTANCE.getDescriptor());
        }
        this.ms = j;
        this.us = (i & 2) == 0 ? 1000 * j : j2;
        if ((i & 4) == 0) {
            this.seconds = j / 1000;
        } else {
            this.seconds = j3;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(Time time, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeLongElement(serialDescriptor, 0, time.ms);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || time.us != time.ms * 1000) {
            compositeEncoder.encodeLongElement(serialDescriptor, 1, time.us);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && time.seconds == time.ms / 1000) {
            return;
        }
        compositeEncoder.encodeLongElement(serialDescriptor, 2, time.seconds);
    }

    public Time(long j) {
        this.ms = j;
        long j2 = 1000;
        this.us = j * j2;
        this.seconds = j / j2;
    }

    public final long getMs() {
        return this.ms;
    }

    public final long getUs() {
        return this.us;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    /* renamed from: minus-5sfh64U  reason: not valid java name */
    public final long m9660minus5sfh64U(Time time) {
        Intrinsics.checkNotNullParameter(time, "time");
        Duration.Companion companion = Duration.Companion;
        return DurationKt.toDuration(this.ms - time.ms, DurationUnit.MILLISECONDS);
    }
}
