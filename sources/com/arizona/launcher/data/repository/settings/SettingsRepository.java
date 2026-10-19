package com.arizona.launcher.data.repository.settings;

import java.util.UUID;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SettingsRepository.kt */
@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\b\u0007\u001a\u0002\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0005\u001a\u00020\u0006Ê\u0001\u0002\b\bÊ\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/data/repository/settings/SettingsRepository;", "", "<init>", "()V", "Ljavax/inject/Inject;", "getNickname", "", "app", "Ljavax/inject/Singleton;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsRepository {
    public static final int $stable = 0;

    public final String getNickname() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String substring = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null).substring(0, 12);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return "Player_" + substring;
    }
}
