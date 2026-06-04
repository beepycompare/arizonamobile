package com.arizona.game.debug.backend;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.ProjectType;
/* compiled from: BackendContractValidation.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007b\u0002\b\tÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/game/debug/backend/BackendContractValidatorRegistry;", "", "<init>", "()V", "create", "", "Lcom/arizona/game/debug/backend/BackendContractValidator;", "projectType", "Lru/mrlargha/commonui/core/ProjectType;", "Lkotlin/jvm/JvmStatic;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackendContractValidatorRegistry {
    public static final int $stable = 0;
    public static final BackendContractValidatorRegistry INSTANCE = new BackendContractValidatorRegistry();

    private BackendContractValidatorRegistry() {
    }

    @JvmStatic
    public static final List<BackendContractValidator> create(ProjectType projectType) {
        Intrinsics.checkNotNullParameter(projectType, "projectType");
        return CollectionsKt.emptyList();
    }
}
