package com.arkivanov.essenty.statekeeper;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
/* compiled from: StateKeeper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\rH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "", "consume", ExifInterface.GPS_DIRECTION_TRUE, "key", "", "strategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Ljava/lang/String;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "register", "", "Lkotlinx/serialization/SerializationStrategy;", "supplier", "Lkotlin/Function0;", "unregister", "isRegistered", "", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface StateKeeper {
    <T> T consume(String str, DeserializationStrategy<? extends T> deserializationStrategy);

    boolean isRegistered(String str);

    <T> void register(String str, SerializationStrategy<? super T> serializationStrategy, Function0<? extends T> function0);

    void unregister(String str);
}
