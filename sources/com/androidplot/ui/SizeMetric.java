package com.androidplot.ui;
/* loaded from: classes3.dex */
public class SizeMetric extends LayoutMetric<SizeMode> {
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.androidplot.ui.SizeMode] */
    @Override // com.androidplot.ui.LayoutMetric
    public /* bridge */ /* synthetic */ SizeMode getLayoutType() {
        return super.getLayoutType();
    }

    @Override // com.androidplot.ui.LayoutMetric
    public /* bridge */ /* synthetic */ float getValue() {
        return super.getValue();
    }

    @Override // com.androidplot.ui.LayoutMetric
    public /* bridge */ /* synthetic */ void set(float f, SizeMode sizeMode) {
        super.set(f, sizeMode);
    }

    @Override // com.androidplot.ui.LayoutMetric
    public /* bridge */ /* synthetic */ void setValue(float f) {
        super.setValue(f);
    }

    public SizeMetric(float f, SizeMode sizeMode) {
        super(f, sizeMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.ui.SizeMetric$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$ui$SizeMode;

        static {
            int[] iArr = new int[SizeMode.values().length];
            $SwitchMap$com$androidplot$ui$SizeMode = iArr;
            try {
                iArr[SizeMode.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$ui$SizeMode[SizeMode.ABSOLUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$androidplot$ui$SizeMode[SizeMode.FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.ui.LayoutMetric
    public void validatePair(float f, SizeMode sizeMode) {
        if (AnonymousClass1.$SwitchMap$com$androidplot$ui$SizeMode[sizeMode.ordinal()] != 1) {
            return;
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("SizeMetric Relative and Hybrid layout values must be within the range of 0 to 1.");
        }
    }

    @Override // com.androidplot.ui.LayoutMetric
    public float getPixelValue(float f) {
        int i = AnonymousClass1.$SwitchMap$com$androidplot$ui$SizeMode[((SizeMode) getLayoutType()).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return f - getValue();
                }
                throw new IllegalArgumentException("Unsupported LayoutType: " + getLayoutType());
            }
            return getValue();
        }
        return getValue() * f;
    }

    @Override // com.androidplot.ui.LayoutMetric
    public void setLayoutType(SizeMode sizeMode) {
        super.setLayoutType((SizeMetric) sizeMode);
    }
}
