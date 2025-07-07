package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r3.mHorizontalChainStyle == 2) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r3.mVerticalChainStyle == 2) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
        r6 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:198:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0528  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        LinearSystem linearSystem2;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        int i3;
        ConstraintAnchor constraintAnchor2;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i4;
        SolverVariable solverVariable4;
        float f;
        int size;
        ArrayList<ConstraintWidget> arrayList;
        float f2;
        boolean z4;
        boolean z5;
        int i5;
        int i6 = i;
        ConstraintWidget constraintWidget6 = chainHead.mFirst;
        ConstraintWidget constraintWidget7 = chainHead.mLast;
        ConstraintWidget constraintWidget8 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mHead;
        float f3 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget11 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget12 = chainHead.mLastMatchConstraintWidget;
        boolean z6 = constraintWidgetContainer.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i6 == 0) {
            z = constraintWidget10.mHorizontalChainStyle == 0;
            z2 = constraintWidget10.mHorizontalChainStyle == 1;
        } else {
            z = constraintWidget10.mVerticalChainStyle == 0;
            z2 = constraintWidget10.mVerticalChainStyle == 1;
        }
        ConstraintWidget constraintWidget13 = constraintWidget6;
        boolean z7 = false;
        while (true) {
            if (z7) {
                break;
            }
            ConstraintAnchor constraintAnchor3 = constraintWidget13.mListAnchors[i2];
            int i7 = z3 ? 1 : 4;
            int margin = constraintAnchor3.getMargin();
            boolean z8 = z6;
            boolean z9 = z3;
            boolean z10 = constraintWidget13.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget13.mResolvedMatchConstraintDefault[i6] == 0;
            if (constraintAnchor3.mTarget != null && constraintWidget13 != constraintWidget6) {
                margin += constraintAnchor3.mTarget.getMargin();
            }
            int i8 = margin;
            if (z9 && constraintWidget13 != constraintWidget6 && constraintWidget13 != constraintWidget8) {
                i7 = 8;
            }
            boolean z11 = z10;
            if (constraintAnchor3.mTarget != null) {
                if (constraintWidget13 == constraintWidget8) {
                    z4 = z7;
                    z5 = z;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i8, 6);
                } else {
                    z4 = z7;
                    z5 = z;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i8, 8);
                }
                if (z11 && !z9) {
                    i7 = 5;
                }
                linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i8, (constraintWidget13 == constraintWidget8 && z9 && constraintWidget13.isInBarrier(i6)) ? 5 : i7);
            } else {
                z4 = z7;
                z5 = z;
            }
            if (z8) {
                if (constraintWidget13.getVisibility() == 8 || constraintWidget13.mListDimensionBehaviors[i6] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5 = 0;
                } else {
                    i5 = 0;
                    linearSystem.addGreaterThan(constraintWidget13.mListAnchors[i2 + 1].mSolverVariable, constraintWidget13.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget13.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i5, 8);
            }
            ConstraintAnchor constraintAnchor4 = constraintWidget13.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor4 != null) {
                ConstraintWidget constraintWidget14 = constraintAnchor4.mOwner;
                if (constraintWidget14.mListAnchors[i2].mTarget != null && constraintWidget14.mListAnchors[i2].mTarget.mOwner == constraintWidget13) {
                    r21 = constraintWidget14;
                }
            }
            if (r21 != null) {
                constraintWidget13 = r21;
                z7 = z4;
            } else {
                z7 = true;
            }
            z6 = z8;
            z3 = z9;
            z = z5;
        }
        boolean z12 = z6;
        boolean z13 = z3;
        boolean z14 = z;
        if (constraintWidget9 != null) {
            int i9 = i2 + 1;
            if (constraintWidget7.mListAnchors[i9].mTarget != null) {
                ConstraintAnchor constraintAnchor5 = constraintWidget9.mListAnchors[i9];
                if (constraintWidget9.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget9.mResolvedMatchConstraintDefault[i6] == 0 && !z13 && constraintAnchor5.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor5.mSolverVariable, constraintAnchor5.mTarget.mSolverVariable, -constraintAnchor5.getMargin(), 5);
                } else if (z13 && constraintAnchor5.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor5.mSolverVariable, constraintAnchor5.mTarget.mSolverVariable, -constraintAnchor5.getMargin(), 4);
                }
                linearSystem.addLowerThan(constraintAnchor5.mSolverVariable, constraintWidget7.mListAnchors[i9].mTarget.mSolverVariable, -constraintAnchor5.getMargin(), 6);
            }
        }
        if (z12) {
            int i10 = i2 + 1;
            linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i10].mSolverVariable, constraintWidget7.mListAnchors[i10].mSolverVariable, constraintWidget7.mListAnchors[i10].getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
            float f4 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f3 : chainHead.mWidgetsMatchCount;
            float f5 = 0.0f;
            float f6 = 0.0f;
            ConstraintWidget constraintWidget15 = null;
            int i11 = 0;
            while (i11 < size) {
                ConstraintWidget constraintWidget16 = arrayList2.get(i11);
                float f7 = constraintWidget16.mWeight[i6];
                if (f7 >= f5) {
                    arrayList = arrayList2;
                    f2 = f5;
                } else if (chainHead.mHasComplexMatchWeights) {
                    arrayList = arrayList2;
                    f2 = f5;
                    linearSystem.addEquality(constraintWidget16.mListAnchors[i2 + 1].mSolverVariable, constraintWidget16.mListAnchors[i2].mSolverVariable, 0, 4);
                    i11++;
                    f5 = f2;
                    arrayList2 = arrayList;
                } else {
                    arrayList = arrayList2;
                    f2 = f5;
                    f7 = 1.0f;
                }
                float f8 = f7;
                if (f8 == f2) {
                    linearSystem.addEquality(constraintWidget16.mListAnchors[i2 + 1].mSolverVariable, constraintWidget16.mListAnchors[i2].mSolverVariable, 0, 8);
                } else {
                    if (constraintWidget15 != null) {
                        SolverVariable solverVariable5 = constraintWidget15.mListAnchors[i2].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr = constraintWidget15.mListAnchors;
                        int i12 = i2 + 1;
                        SolverVariable solverVariable6 = constraintAnchorArr[i12].mSolverVariable;
                        SolverVariable solverVariable7 = constraintWidget16.mListAnchors[i2].mSolverVariable;
                        SolverVariable solverVariable8 = constraintWidget16.mListAnchors[i12].mSolverVariable;
                        ArrayRow createRow = linearSystem.createRow();
                        createRow.createRowEqualMatchDimensions(f6, f4, f8, solverVariable5, solverVariable6, solverVariable7, solverVariable8);
                        linearSystem.addConstraint(createRow);
                    }
                    constraintWidget15 = constraintWidget16;
                    f6 = f8;
                }
                i11++;
                f5 = f2;
                arrayList2 = arrayList;
            }
        }
        if (constraintWidget8 != null && (constraintWidget8 == constraintWidget9 || z13)) {
            ConstraintAnchor constraintAnchor6 = constraintWidget6.mListAnchors[i2];
            int i13 = i2 + 1;
            ConstraintAnchor constraintAnchor7 = constraintWidget7.mListAnchors[i13];
            SolverVariable solverVariable9 = constraintAnchor6.mTarget != null ? constraintAnchor6.mTarget.mSolverVariable : null;
            SolverVariable solverVariable10 = constraintAnchor7.mTarget != null ? constraintAnchor7.mTarget.mSolverVariable : null;
            ConstraintAnchor constraintAnchor8 = constraintWidget8.mListAnchors[i2];
            if (constraintWidget9 != null) {
                constraintAnchor7 = constraintWidget9.mListAnchors[i13];
            }
            if (solverVariable9 != null && solverVariable10 != null) {
                if (i6 == 0) {
                    f = constraintWidget10.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget10.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor8.mSolverVariable, solverVariable9, constraintAnchor8.getMargin(), f, solverVariable10, constraintAnchor7.mSolverVariable, constraintAnchor7.getMargin(), 7);
            }
        } else if (!z14 || constraintWidget8 == null) {
            int i14 = 8;
            if (z2 && constraintWidget8 != null) {
                boolean z15 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                ConstraintWidget constraintWidget17 = constraintWidget8;
                ConstraintWidget constraintWidget18 = constraintWidget17;
                while (constraintWidget18 != null) {
                    ConstraintWidget constraintWidget19 = constraintWidget18.mNextChainWidget[i];
                    while (constraintWidget19 != null && constraintWidget19.getVisibility() == i14) {
                        constraintWidget19 = constraintWidget19.mNextChainWidget[i];
                    }
                    if (constraintWidget18 == constraintWidget8 || constraintWidget18 == constraintWidget9 || constraintWidget19 == null) {
                        constraintWidget = constraintWidget17;
                    } else {
                        if (constraintWidget19 == constraintWidget9) {
                            constraintWidget19 = null;
                        }
                        ConstraintAnchor constraintAnchor9 = constraintWidget18.mListAnchors[i2];
                        SolverVariable solverVariable11 = constraintAnchor9.mSolverVariable;
                        if (constraintAnchor9.mTarget != null) {
                            SolverVariable solverVariable12 = constraintAnchor9.mTarget.mSolverVariable;
                        }
                        int i15 = i2 + 1;
                        SolverVariable solverVariable13 = constraintWidget17.mListAnchors[i15].mSolverVariable;
                        int margin2 = constraintAnchor9.getMargin();
                        int margin3 = constraintWidget18.mListAnchors[i15].getMargin();
                        if (constraintWidget19 != null) {
                            constraintAnchor = constraintWidget19.mListAnchors[i2];
                            solverVariable = constraintAnchor.mSolverVariable;
                            solverVariable2 = constraintAnchor.mTarget != null ? constraintAnchor.mTarget.mSolverVariable : null;
                        } else {
                            constraintAnchor = constraintWidget9.mListAnchors[i2];
                            solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                            solverVariable2 = constraintWidget18.mListAnchors[i15].mSolverVariable;
                        }
                        if (constraintAnchor != null) {
                            margin3 += constraintAnchor.getMargin();
                        }
                        int i16 = margin3;
                        int margin4 = margin2 + constraintWidget17.mListAnchors[i15].getMargin();
                        SolverVariable solverVariable14 = solverVariable;
                        int i17 = z15 ? 8 : 4;
                        if (solverVariable11 == null || solverVariable13 == null || solverVariable14 == null || solverVariable2 == null) {
                            constraintWidget = constraintWidget17;
                            constraintWidget2 = constraintWidget19;
                        } else {
                            constraintWidget2 = constraintWidget19;
                            SolverVariable solverVariable15 = solverVariable2;
                            constraintWidget = constraintWidget17;
                            linearSystem.addCentering(solverVariable11, solverVariable13, margin4, 0.5f, solverVariable14, solverVariable15, i16, i17);
                        }
                        constraintWidget19 = constraintWidget2;
                    }
                    if (constraintWidget18.getVisibility() == 8) {
                        constraintWidget18 = constraintWidget;
                    }
                    i14 = 8;
                    constraintWidget17 = constraintWidget18;
                    constraintWidget18 = constraintWidget19;
                }
                linearSystem2 = linearSystem;
                ConstraintAnchor constraintAnchor10 = constraintWidget8.mListAnchors[i2];
                ConstraintAnchor constraintAnchor11 = constraintWidget6.mListAnchors[i2].mTarget;
                int i18 = i2 + 1;
                ConstraintAnchor constraintAnchor12 = constraintWidget9.mListAnchors[i18];
                ConstraintAnchor constraintAnchor13 = constraintWidget7.mListAnchors[i18].mTarget;
                if (constraintAnchor11 != null) {
                    if (constraintWidget8 != constraintWidget9) {
                        linearSystem2.addEquality(constraintAnchor10.mSolverVariable, constraintAnchor11.mSolverVariable, constraintAnchor10.getMargin(), 5);
                    } else if (constraintAnchor13 != null) {
                        linearSystem2.addCentering(constraintAnchor10.mSolverVariable, constraintAnchor11.mSolverVariable, constraintAnchor10.getMargin(), 0.5f, constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, constraintAnchor12.getMargin(), 5);
                    }
                }
                if (constraintAnchor13 != null && constraintWidget8 != constraintWidget9) {
                    linearSystem2.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, -constraintAnchor12.getMargin(), 5);
                }
                if ((z14 && !z2) || constraintWidget8 == null || constraintWidget8 == constraintWidget9) {
                    return;
                }
                ConstraintAnchor constraintAnchor14 = constraintWidget8.mListAnchors[i2];
                if (constraintWidget9 == null) {
                    constraintWidget9 = constraintWidget8;
                }
                int i19 = i2 + 1;
                ConstraintAnchor constraintAnchor15 = constraintWidget9.mListAnchors[i19];
                solverVariable4 = constraintAnchor14.mTarget == null ? constraintAnchor14.mTarget.mSolverVariable : null;
                SolverVariable solverVariable16 = constraintAnchor15.mTarget == null ? constraintAnchor15.mTarget.mSolverVariable : null;
                if (constraintWidget7 != constraintWidget9) {
                    ConstraintAnchor constraintAnchor16 = constraintWidget7.mListAnchors[i19];
                    solverVariable16 = constraintAnchor16.mTarget != null ? constraintAnchor16.mTarget.mSolverVariable : null;
                }
                if (constraintWidget8 == constraintWidget9) {
                    constraintAnchor14 = constraintWidget8.mListAnchors[i2];
                    constraintAnchor15 = constraintWidget8.mListAnchors[i19];
                }
                if (solverVariable4 != null || solverVariable16 == null) {
                }
                linearSystem2.addCentering(constraintAnchor14.mSolverVariable, solverVariable4, constraintAnchor14.getMargin(), 0.5f, solverVariable16, constraintAnchor15.mSolverVariable, constraintWidget9.mListAnchors[i19].getMargin(), 5);
                return;
            }
        } else {
            boolean z16 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
            ConstraintWidget constraintWidget20 = constraintWidget8;
            for (ConstraintWidget constraintWidget21 = constraintWidget20; constraintWidget21 != null; constraintWidget21 = constraintWidget4) {
                ConstraintWidget constraintWidget22 = constraintWidget21.mNextChainWidget[i6];
                while (true) {
                    if (constraintWidget22 == null) {
                        i3 = 8;
                        break;
                    }
                    i3 = 8;
                    if (constraintWidget22.getVisibility() != 8) {
                        break;
                    }
                    constraintWidget22 = constraintWidget22.mNextChainWidget[i6];
                }
                if (constraintWidget22 != null || constraintWidget21 == constraintWidget9) {
                    ConstraintAnchor constraintAnchor17 = constraintWidget21.mListAnchors[i2];
                    SolverVariable solverVariable17 = constraintAnchor17.mSolverVariable;
                    SolverVariable solverVariable18 = constraintAnchor17.mTarget != null ? constraintAnchor17.mTarget.mSolverVariable : null;
                    if (constraintWidget20 != constraintWidget21) {
                        solverVariable18 = constraintWidget20.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget21 == constraintWidget8) {
                        solverVariable18 = constraintWidget6.mListAnchors[i2].mTarget != null ? constraintWidget6.mListAnchors[i2].mTarget.mSolverVariable : null;
                    }
                    int margin5 = constraintAnchor17.getMargin();
                    int i20 = i2 + 1;
                    int margin6 = constraintWidget21.mListAnchors[i20].getMargin();
                    if (constraintWidget22 != null) {
                        constraintAnchor2 = constraintWidget22.mListAnchors[i2];
                        solverVariable3 = constraintAnchor2.mSolverVariable;
                    } else {
                        constraintAnchor2 = constraintWidget7.mListAnchors[i20].mTarget;
                        if (constraintAnchor2 != null) {
                            solverVariable3 = constraintAnchor2.mSolverVariable;
                        } else {
                            constraintWidget3 = constraintWidget22;
                            solverVariable3 = null;
                            SolverVariable solverVariable19 = constraintWidget21.mListAnchors[i20].mSolverVariable;
                            if (constraintAnchor2 != null) {
                                margin6 += constraintAnchor2.getMargin();
                            }
                            int margin7 = margin5 + constraintWidget20.mListAnchors[i20].getMargin();
                            if (solverVariable17 != null || solverVariable18 == null || solverVariable3 == null || solverVariable19 == null) {
                                constraintWidget4 = constraintWidget3;
                                constraintWidget5 = constraintWidget20;
                                i4 = 8;
                            } else {
                                if (constraintWidget21 == constraintWidget8) {
                                    margin7 = constraintWidget8.mListAnchors[i2].getMargin();
                                }
                                if (constraintWidget21 == constraintWidget9) {
                                    margin6 = constraintWidget9.mListAnchors[i20].getMargin();
                                }
                                constraintWidget4 = constraintWidget3;
                                constraintWidget5 = constraintWidget20;
                                i4 = 8;
                                linearSystem.addCentering(solverVariable17, solverVariable18, margin7, 0.5f, solverVariable3, solverVariable19, margin6, z16 ? 8 : 5);
                                constraintWidget20 = constraintWidget21.getVisibility() == i4 ? constraintWidget21 : constraintWidget5;
                                i6 = i;
                            }
                        }
                    }
                    constraintWidget3 = constraintWidget22;
                    SolverVariable solverVariable192 = constraintWidget21.mListAnchors[i20].mSolverVariable;
                    if (constraintAnchor2 != null) {
                    }
                    int margin72 = margin5 + constraintWidget20.mListAnchors[i20].getMargin();
                    if (solverVariable17 != null) {
                    }
                    constraintWidget4 = constraintWidget3;
                    constraintWidget5 = constraintWidget20;
                    i4 = 8;
                } else {
                    constraintWidget5 = constraintWidget20;
                    constraintWidget4 = constraintWidget22;
                    i4 = i3;
                }
                if (constraintWidget21.getVisibility() == i4) {
                }
                i6 = i;
            }
        }
        linearSystem2 = linearSystem;
        if (z14) {
        }
        ConstraintAnchor constraintAnchor142 = constraintWidget8.mListAnchors[i2];
        if (constraintWidget9 == null) {
        }
        int i192 = i2 + 1;
        ConstraintAnchor constraintAnchor152 = constraintWidget9.mListAnchors[i192];
        if (constraintAnchor142.mTarget == null) {
        }
        if (constraintAnchor152.mTarget == null) {
        }
        if (constraintWidget7 != constraintWidget9) {
        }
        if (constraintWidget8 == constraintWidget9) {
        }
        if (solverVariable4 != null) {
        }
    }
}
