package io.appmetrica.analytics.coreapi.internal.identifiers;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdScope;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "UNKNOWN", "APP", "DEVELOPER", "core-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class AppSetIdScope {
    public static final AppSetIdScope APP;
    public static final AppSetIdScope DEVELOPER;
    public static final AppSetIdScope UNKNOWN;
    private static final /* synthetic */ AppSetIdScope[] b;
    private static final /* synthetic */ EnumEntries c;

    /* renamed from: a  reason: collision with root package name */
    private final String f320a;

    static {
        AppSetIdScope appSetIdScope = new AppSetIdScope("UNKNOWN", 0, "");
        UNKNOWN = appSetIdScope;
        AppSetIdScope appSetIdScope2 = new AppSetIdScope("APP", 1, "app");
        APP = appSetIdScope2;
        AppSetIdScope appSetIdScope3 = new AppSetIdScope("DEVELOPER", 2, "developer");
        DEVELOPER = appSetIdScope3;
        AppSetIdScope[] appSetIdScopeArr = {appSetIdScope, appSetIdScope2, appSetIdScope3};
        b = appSetIdScopeArr;
        c = EnumEntriesKt.enumEntries(appSetIdScopeArr);
    }

    private AppSetIdScope(String str, int i, String str2) {
        this.f320a = str2;
    }

    public static EnumEntries<AppSetIdScope> getEntries() {
        return c;
    }

    public static AppSetIdScope valueOf(String str) {
        return (AppSetIdScope) Enum.valueOf(AppSetIdScope.class, str);
    }

    public static AppSetIdScope[] values() {
        return (AppSetIdScope[]) b.clone();
    }

    public final String getValue() {
        return this.f320a;
    }
}
