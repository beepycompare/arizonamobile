package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class HorizontalChainReference extends ChainReference {
    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mHelperState.constraints(it.next()).clearHorizontal();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            Object next = it2.next();
            ConstraintReference constraints = this.mHelperState.constraints(next);
            if (constraintReference2 == null) {
                if (this.mStartToStart != null) {
                    constraints.startToStart(this.mStartToStart).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                } else if (this.mStartToEnd != null) {
                    constraints.startToEnd(this.mStartToEnd).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                } else if (this.mLeftToLeft != null) {
                    constraints.startToStart(this.mLeftToLeft).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                } else if (this.mLeftToRight != null) {
                    constraints.startToEnd(this.mLeftToRight).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                } else {
                    String obj = constraints.getKey().toString();
                    constraints.startToStart(State.PARENT).margin(Float.valueOf(getPreMargin(obj))).marginGone(Float.valueOf(getPreGoneMargin(obj)));
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                String obj2 = constraintReference.getKey().toString();
                String obj3 = constraints.getKey().toString();
                constraintReference.endToStart(constraints.getKey()).margin(Float.valueOf(getPostMargin(obj2))).marginGone(Float.valueOf(getPostGoneMargin(obj2)));
                constraints.startToEnd(constraintReference.getKey()).margin(Float.valueOf(getPreMargin(obj3))).marginGone(Float.valueOf(getPreGoneMargin(obj3)));
            }
            float weight = getWeight(next.toString());
            if (weight != -1.0f) {
                constraints.setHorizontalChainWeight(weight);
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            if (this.mEndToStart != null) {
                constraintReference.endToStart(this.mEndToStart).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
            } else if (this.mEndToEnd != null) {
                constraintReference.endToEnd(this.mEndToEnd).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
            } else if (this.mRightToLeft != null) {
                constraintReference.endToStart(this.mRightToLeft).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
            } else if (this.mRightToRight != null) {
                constraintReference.endToEnd(this.mRightToRight).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
            } else {
                String obj4 = constraintReference.getKey().toString();
                constraintReference.endToEnd(State.PARENT).margin(Float.valueOf(getPostMargin(obj4))).marginGone(Float.valueOf(getPostGoneMargin(obj4)));
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        if (this.mBias != 0.5f) {
            constraintReference2.horizontalBias(this.mBias);
        }
        int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (i == 1) {
            constraintReference2.setHorizontalChainStyle(0);
        } else if (i == 2) {
            constraintReference2.setHorizontalChainStyle(1);
        } else if (i != 3) {
        } else {
            constraintReference2.setHorizontalChainStyle(2);
        }
    }

    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain;

        static {
            int[] iArr = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
