package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
/* compiled from: TransitionScope.kt */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R+\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011¨\u0006\u001f"}, d2 = {"Landroidx/constraintlayout/compose/KeyPositionScope;", "Landroidx/constraintlayout/compose/BaseKeyFrameScope;", "()V", "<set-?>", "Landroidx/constraintlayout/compose/CurveFit;", "curveFit", "getCurveFit", "()Landroidx/constraintlayout/compose/CurveFit;", "setCurveFit", "(Landroidx/constraintlayout/compose/CurveFit;)V", "curveFit$delegate", "Lkotlin/properties/ObservableProperty;", "", "percentHeight", "getPercentHeight", "()F", "setPercentHeight", "(F)V", "percentHeight$delegate", "percentWidth", "getPercentWidth", "setPercentWidth", "percentWidth$delegate", "percentX", "getPercentX", "setPercentX", "percentX$delegate", "percentY", "getPercentY", "setPercentY", "percentY$delegate", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KeyPositionScope extends BaseKeyFrameScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyPositionScope.class, "percentX", "getPercentX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyPositionScope.class, "percentY", "getPercentY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyPositionScope.class, "percentWidth", "getPercentWidth()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyPositionScope.class, "percentHeight", "getPercentHeight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyPositionScope.class, "curveFit", "getCurveFit()Landroidx/constraintlayout/compose/CurveFit;", 0))};
    public static final int $stable = 8;
    private final ObservableProperty curveFit$delegate;
    private final ObservableProperty percentHeight$delegate;
    private final ObservableProperty percentWidth$delegate;
    private final ObservableProperty percentX$delegate;
    private final ObservableProperty percentY$delegate;

    public KeyPositionScope() {
        super(null);
        KeyPositionScope keyPositionScope = this;
        Float valueOf = Float.valueOf(1.0f);
        this.percentX$delegate = BaseKeyFrameScope.addOnPropertyChange$default(keyPositionScope, valueOf, null, 2, null);
        this.percentY$delegate = BaseKeyFrameScope.addOnPropertyChange$default(keyPositionScope, valueOf, null, 2, null);
        this.percentWidth$delegate = BaseKeyFrameScope.addOnPropertyChange$default(keyPositionScope, valueOf, null, 2, null);
        this.percentHeight$delegate = BaseKeyFrameScope.addOnPropertyChange$default(keyPositionScope, Float.valueOf(0.0f), null, 2, null);
        this.curveFit$delegate = BaseKeyFrameScope.addNameOnPropertyChange$default(keyPositionScope, null, null, 2, null);
    }

    public final float getPercentX() {
        return ((Number) this.percentX$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final void setPercentX(float f) {
        this.percentX$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f));
    }

    public final float getPercentY() {
        return ((Number) this.percentY$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final void setPercentY(float f) {
        this.percentY$delegate.setValue(this, $$delegatedProperties[1], Float.valueOf(f));
    }

    public final float getPercentWidth() {
        return ((Number) this.percentWidth$delegate.getValue(this, $$delegatedProperties[2])).floatValue();
    }

    public final void setPercentWidth(float f) {
        this.percentWidth$delegate.setValue(this, $$delegatedProperties[2], Float.valueOf(f));
    }

    public final float getPercentHeight() {
        return ((Number) this.percentHeight$delegate.getValue(this, $$delegatedProperties[3])).floatValue();
    }

    public final void setPercentHeight(float f) {
        this.percentHeight$delegate.setValue(this, $$delegatedProperties[3], Float.valueOf(f));
    }

    public final CurveFit getCurveFit() {
        return (CurveFit) this.curveFit$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void setCurveFit(CurveFit curveFit) {
        this.curveFit$delegate.setValue(this, $$delegatedProperties[4], curveFit);
    }
}
