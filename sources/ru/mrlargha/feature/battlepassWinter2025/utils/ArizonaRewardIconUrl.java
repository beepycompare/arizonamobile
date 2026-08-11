package ru.mrlargha.feature.battlepassWinter2025.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArizonaMissionHelpers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaRewardIconUrl;", "", "<init>", "()V", "PATH", "", "build", "cdnBaseUrl", "itemId", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRewardIconUrl {
    public static final ArizonaRewardIconUrl INSTANCE = new ArizonaRewardIconUrl();
    private static final String PATH = "assets/images/donate";

    private ArizonaRewardIconUrl() {
    }

    public final String build(String cdnBaseUrl, int i) {
        Intrinsics.checkNotNullParameter(cdnBaseUrl, "cdnBaseUrl");
        return StringsKt.trimEnd(cdnBaseUrl, '/') + "/assets/images/donate/" + i + ".webp";
    }
}
