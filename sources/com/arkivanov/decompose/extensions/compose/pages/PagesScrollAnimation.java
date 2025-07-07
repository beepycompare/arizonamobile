package com.arkivanov.decompose.extensions.compose.pages;

import androidx.compose.animation.core.AnimationSpec;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PagesScrollAnimation.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;", "", "Disabled", "Default", TypedValues.Custom.NAME, "Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation$Custom;", "Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation$Default;", "Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation$Disabled;", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PagesScrollAnimation {

    /* compiled from: PagesScrollAnimation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation$Disabled;", "Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Disabled implements PagesScrollAnimation {
        public static final int $stable = 0;
        public static final Disabled INSTANCE = new Disabled();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Disabled) {
                Disabled disabled = (Disabled) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -140971084;
        }

        public String toString() {
            return "Disabled";
        }

        private Disabled() {
        }
    }

    /* compiled from: PagesScrollAnimation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation$Default;", "Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Default implements PagesScrollAnimation {
        public static final int $stable = 0;
        public static final Default INSTANCE = new Default();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Default) {
                Default r3 = (Default) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1531516425;
        }

        public String toString() {
            return "Default";
        }

        private Default() {
        }
    }

    /* compiled from: PagesScrollAnimation.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation$Custom;", "Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;", "spec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "getSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Custom implements PagesScrollAnimation {
        public static final int $stable = 8;
        private final AnimationSpec<Float> spec;

        public Custom(AnimationSpec<Float> spec) {
            Intrinsics.checkNotNullParameter(spec, "spec");
            this.spec = spec;
        }

        public final AnimationSpec<Float> getSpec() {
            return this.spec;
        }
    }
}
