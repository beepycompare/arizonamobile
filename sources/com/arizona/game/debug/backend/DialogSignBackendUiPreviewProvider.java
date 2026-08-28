package com.arizona.game.debug.backend;

import android.util.Log;
import com.arizona.game.GTASA;
import com.miami.game.core.settings.game_test.BackendFixture;
import com.miami.game.core.settings.game_test.BackendFixtureEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ru.mrlargha.commonui.core.ProjectType;
/* compiled from: BackendUiPreview.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/arizona/game/debug/backend/DialogSignBackendUiPreviewProvider;", "Lcom/arizona/game/debug/backend/BackendUiPreviewProvider;", "<init>", "()V", "canPreview", "", "projectType", "Lru/mrlargha/commonui/core/ProjectType;", "provider", "", "fixture", "Lcom/miami/game/core/settings/game_test/BackendFixture;", "preview", "gtasa", "Lcom/arizona/game/GTASA;", "Companion", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class DialogSignBackendUiPreviewProvider implements BackendUiPreviewProvider {
    private static final Companion Companion = new Companion(null);
    private static final String DEFAULT_CAPTION = "ПОСТАВЬТЕ ПОДПИСЬ";
    private static final int DEFAULT_DIALOG_ID = 700;
    private static final String DEFAULT_INFO_TEXT = "{\"text\":\"Заполнено на\",\"value\":0,\"color\":\"#FF0000\"}";
    private static final String DEFAULT_PRIMARY_BUTTON = "ПОДТВЕРДИТЬ";
    private static final String DIALOG_SIGN_PROVIDER = "common_dialog_sign";
    private static final String DIALOG_SIGN_SCREEN = "dialog_sign";
    private static final int DIALOG_STYLE_SIGN = 7;
    private static final String TAG = "DialogSignPreview";

    @Override // com.arizona.game.debug.backend.BackendUiPreviewProvider
    public boolean canPreview(ProjectType projectType, String str, BackendFixture fixture) {
        Intrinsics.checkNotNullParameter(projectType, "projectType");
        Intrinsics.checkNotNullParameter(fixture, "fixture");
        if (projectType != ProjectType.ARIZONA) {
            return false;
        }
        return Intrinsics.areEqual(str, DIALOG_SIGN_PROVIDER) || Intrinsics.areEqual(fixture.getPreviewScreen(), DIALOG_SIGN_SCREEN);
    }

    @Override // com.arizona.game.debug.backend.BackendUiPreviewProvider
    public boolean preview(GTASA gtasa, BackendFixture fixture) {
        String message;
        Boolean m9920constructorimpl;
        Intrinsics.checkNotNullParameter(gtasa, "gtasa");
        Intrinsics.checkNotNullParameter(fixture, "fixture");
        BackendFixtureEvent backendFixtureEvent = (BackendFixtureEvent) CollectionsKt.firstOrNull((List<? extends Object>) fixture.getEvents());
        if (backendFixtureEvent != null && (message = backendFixtureEvent.getMessage()) != null) {
            if (StringsKt.isBlank(message)) {
                message = null;
            }
            if (message != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    DialogSignBackendUiPreviewProvider dialogSignBackendUiPreviewProvider = this;
                    JSONObject jSONObject = new JSONObject(message);
                    int optInt = jSONObject.optInt("dialogId", jSONObject.optInt("sampDialogId", 700));
                    int optInt2 = jSONObject.optInt("style", 7);
                    String optString = jSONObject.optString("caption", DEFAULT_CAPTION);
                    String optString2 = jSONObject.optString("infoText", DEFAULT_INFO_TEXT);
                    String optString3 = jSONObject.optString("leftButton", DEFAULT_PRIMARY_BUTTON);
                    String optString4 = jSONObject.optString("rightButton", "");
                    String optString5 = jSONObject.optString("placeholder", "");
                    Intrinsics.checkNotNull(optString);
                    byte[] bytes = optString.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    Intrinsics.checkNotNull(optString2);
                    byte[] bytes2 = optString2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                    Intrinsics.checkNotNull(optString3);
                    byte[] bytes3 = optString3.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                    Intrinsics.checkNotNull(optString4);
                    byte[] bytes4 = optString4.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
                    Intrinsics.checkNotNull(optString5);
                    byte[] bytes5 = optString5.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes5, "getBytes(...)");
                    gtasa.showPlayerDialog(optInt, optInt2, bytes, bytes2, bytes3, bytes4, bytes5);
                    m9920constructorimpl = Result.m9920constructorimpl(true);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(m9920constructorimpl);
                if (m9923exceptionOrNullimpl != null) {
                    Log.e(TAG, "Unable to preview dialog sign fixture '" + fixture.getName() + "'", m9923exceptionOrNullimpl);
                }
                if (Result.m9926isFailureimpl(m9920constructorimpl)) {
                    m9920constructorimpl = false;
                }
                return ((Boolean) m9920constructorimpl).booleanValue();
            }
        }
        return false;
    }

    /* compiled from: BackendUiPreview.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/game/debug/backend/DialogSignBackendUiPreviewProvider$Companion;", "", "<init>", "()V", "TAG", "", "DIALOG_SIGN_PROVIDER", "DIALOG_SIGN_SCREEN", "DIALOG_STYLE_SIGN", "", "DEFAULT_DIALOG_ID", "DEFAULT_CAPTION", "DEFAULT_PRIMARY_BUTTON", "DEFAULT_INFO_TEXT", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
