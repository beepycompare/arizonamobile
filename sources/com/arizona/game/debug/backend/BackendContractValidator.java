package com.arizona.game.debug.backend;

import com.miami.game.core.settings.game_test.BackendFixture;
import kotlin.Metadata;
import ru.mrlargha.commonui.core.ProjectType;
/* compiled from: BackendContractValidation.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/arizona/game/debug/backend/BackendContractValidator;", "", "canValidate", "", "projectType", "Lru/mrlargha/commonui/core/ProjectType;", "provider", "", "fixture", "Lcom/miami/game/core/settings/game_test/BackendFixture;", "validate", "Lcom/arizona/game/debug/backend/BackendValidationReport;", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BackendContractValidator {
    boolean canValidate(ProjectType projectType, String str, BackendFixture backendFixture);

    BackendValidationReport validate(BackendFixture backendFixture);
}
