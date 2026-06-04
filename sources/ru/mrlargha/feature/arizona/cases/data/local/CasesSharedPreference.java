package ru.mrlargha.feature.arizona.cases.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CasesSharedPreference.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/arizona/cases/data/local/CasesSharedPreference;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "sharedPreferences", "Landroid/content/SharedPreferences;", "value", "", "isHaveSpecialCase", "()Z", "setHaveSpecialCase", "(Z)V", "Companion", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesSharedPreference {
    private static final String CASES_SHARED_PREF_NAME = "casesSharedPref";
    public static final Companion Companion = new Companion(null);
    private static final String IS_HAVE_SPECIAL_CASE = "isHavaSpecialCase";
    private final Context context;
    private boolean isHaveSpecialCase;
    private final SharedPreferences sharedPreferences;

    public CasesSharedPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(CASES_SHARED_PREF_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isHaveSpecialCase() {
        return this.sharedPreferences.getBoolean(IS_HAVE_SPECIAL_CASE, false);
    }

    public final void setHaveSpecialCase(boolean z) {
        this.isHaveSpecialCase = this.sharedPreferences.edit().putBoolean(IS_HAVE_SPECIAL_CASE, z).commit();
    }

    /* compiled from: CasesSharedPreference.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/arizona/cases/data/local/CasesSharedPreference$Companion;", "", "<init>", "()V", "CASES_SHARED_PREF_NAME", "", "IS_HAVE_SPECIAL_CASE", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
