package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class HelperReferences extends WidgetRun {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.mRunGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
    }

    private void addDependency(DependencyNode dependencyNode) {
        this.start.mDependencies.add(dependencyNode);
        dependencyNode.mTargets.add(this.start);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        if (this.mWidget instanceof Barrier) {
            this.start.delegateToWidgetRun = true;
            Barrier barrier = (Barrier) this.mWidget;
            int barrierType = barrier.getBarrierType();
            boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
            int i = 0;
            if (barrierType == 0) {
                this.start.mType = DependencyNode.Type.LEFT;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget.getVisibility() != 8) {
                        DependencyNode dependencyNode = constraintWidget.mHorizontalRun.start;
                        dependencyNode.mDependencies.add(this.start);
                        this.start.mTargets.add(dependencyNode);
                    }
                    i++;
                }
                addDependency(this.mWidget.mHorizontalRun.start);
                addDependency(this.mWidget.mHorizontalRun.end);
            } else if (barrierType == 1) {
                this.start.mType = DependencyNode.Type.RIGHT;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget2 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget2.mHorizontalRun.end;
                        dependencyNode2.mDependencies.add(this.start);
                        this.start.mTargets.add(dependencyNode2);
                    }
                    i++;
                }
                addDependency(this.mWidget.mHorizontalRun.start);
                addDependency(this.mWidget.mHorizontalRun.end);
            } else if (barrierType == 2) {
                this.start.mType = DependencyNode.Type.TOP;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget3 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget3.mVerticalRun.start;
                        dependencyNode3.mDependencies.add(this.start);
                        this.start.mTargets.add(dependencyNode3);
                    }
                    i++;
                }
                addDependency(this.mWidget.mVerticalRun.start);
                addDependency(this.mWidget.mVerticalRun.end);
            } else if (barrierType != 3) {
            } else {
                this.start.mType = DependencyNode.Type.BOTTOM;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget4.mVerticalRun.end;
                        dependencyNode4.mDependencies.add(this.start);
                        this.start.mTargets.add(dependencyNode4);
                    }
                    i++;
                }
                addDependency(this.mWidget.mVerticalRun.start);
                addDependency(this.mWidget.mVerticalRun.end);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.mWidget;
        int barrierType = barrier.getBarrierType();
        int i = 0;
        int i2 = -1;
        for (DependencyNode dependencyNode : this.start.mTargets) {
            int i3 = dependencyNode.value;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            this.start.resolve(i2 + barrier.getMargin());
        } else {
            this.start.resolve(i + barrier.getMargin());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.mWidget instanceof Barrier) {
            int barrierType = ((Barrier) this.mWidget).getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                this.mWidget.setX(this.start.value);
            } else {
                this.mWidget.setY(this.start.value);
            }
        }
    }
}
