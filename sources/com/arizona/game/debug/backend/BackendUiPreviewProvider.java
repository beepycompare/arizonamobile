package com.arizona.game.debug.backend;

import com.arizona.game.GTASA;
import com.miami.game.core.settings.game_test.BackendFixture;
import kotlin.Metadata;
import ru.mrlargha.commonui.core.ProjectType;
/* compiled from: BackendUiPreview.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/arizona/game/debug/backend/BackendUiPreviewProvider;", "", "canPreview", "", "projectType", "Lru/mrlargha/commonui/core/ProjectType;", "provider", "", "fixture", "Lcom/miami/game/core/settings/game_test/BackendFixture;", "preview", "gtasa", "Lcom/arizona/game/GTASA;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BackendUiPreviewProvider {
    boolean canPreview(ProjectType projectType, String str, BackendFixture backendFixture);

    boolean preview(GTASA gtasa, BackendFixture backendFixture);
}
