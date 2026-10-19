package com.arizona.launcher.updater.archive.orchestrator;

import android.content.SharedPreferences;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ViceCityArchiveContentManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J)\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/AndroidViceCityArchiveDeleteMarker;", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveDeleteMarker;", "preferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "isPending", "", "markPending", "", "clearPending", "edit", "action", "", "change", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidViceCityArchiveDeleteMarker implements ViceCityArchiveDeleteMarker {
    private static final String KEY_PENDING = "vice_city_archive_delete_pending";
    private final SharedPreferences preferences;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AndroidViceCityArchiveDeleteMarker(SharedPreferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.preferences = preferences;
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveDeleteMarker
    public boolean isPending() {
        return this.preferences.getBoolean(KEY_PENDING, false);
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveDeleteMarker
    public void markPending() {
        edit("mark", new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.AndroidViceCityArchiveDeleteMarker$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AndroidViceCityArchiveDeleteMarker.markPending$lambda$0((SharedPreferences.Editor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit markPending$lambda$0(SharedPreferences.Editor edit) {
        Intrinsics.checkNotNullParameter(edit, "$this$edit");
        edit.putBoolean(KEY_PENDING, true);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveDeleteMarker
    public void clearPending() {
        edit("clear", new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.AndroidViceCityArchiveDeleteMarker$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AndroidViceCityArchiveDeleteMarker.clearPending$lambda$0((SharedPreferences.Editor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit clearPending$lambda$0(SharedPreferences.Editor edit) {
        Intrinsics.checkNotNullParameter(edit, "$this$edit");
        edit.remove(KEY_PENDING);
        return Unit.INSTANCE;
    }

    private final void edit(String str, Function1<? super SharedPreferences.Editor, Unit> function1) {
        SharedPreferences.Editor edit = this.preferences.edit();
        Intrinsics.checkNotNull(edit);
        function1.invoke(edit);
        if (!edit.commit()) {
            throw new IOException("Unable to " + str + " Vice-City delete marker");
        }
    }

    /* compiled from: ViceCityArchiveContentManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/AndroidViceCityArchiveDeleteMarker$Companion;", "", "<init>", "()V", "KEY_PENDING", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
