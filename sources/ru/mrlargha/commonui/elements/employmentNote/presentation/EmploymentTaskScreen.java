package ru.mrlargha.commonui.elements.employmentNote.presentation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.EmploymentTasksScreenBinding;
import ru.mrlargha.commonui.databinding.LayoutEmploymentInfoBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.employmentNote.domain.FractionTasks;
import ru.mrlargha.commonui.elements.employmentNote.domain.TaskHistory;
import ru.mrlargha.commonui.elements.employmentNote.domain.TaskInfo;
import ru.mrlargha.commonui.elements.employmentNote.domain.TaskListResponse;
import ru.mrlargha.commonui.elements.employmentNote.domain.TaskStats;
import ru.mrlargha.commonui.elements.employmentNote.presentation.adapter.EmploymentHistoryAdapter;
import ru.mrlargha.commonui.elements.employmentNote.presentation.adapter.TaskAdapter;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: EmploymentTaskScreen.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0017H\u0002J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0006H\u0002J\b\u00101\u001a\u00020\u001dH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/presentation/EmploymentTaskScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/EmploymentTasksScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "taskAdapter", "Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/TaskAdapter;", "employmentHistoryAdapter", "Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/EmploymentHistoryAdapter;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "isEmptyTasks", "isEmptyHistory", "currentMemberName", "", "setVisible", "", "visible", "initAdapters", "screenButtonStatus", "btnType", "showDefaultEmptyFractionView", "onBackendMessage", "data", "subId", "showTaskStats", "Lru/mrlargha/commonui/databinding/LayoutEmploymentInfoBinding;", "taskStats", "Lru/mrlargha/commonui/elements/employmentNote/domain/TaskStats;", "blockClickable", "isBlock", "showTasksUi", "response", "Lru/mrlargha/commonui/elements/employmentNote/domain/TaskListResponse;", "isVisibleHistoryLayout", "sendData", "closeScreen", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmploymentTaskScreen extends SAMPUIElement implements InterfaceController {
    private final EmploymentTasksScreenBinding binding;
    private String currentMemberName;
    private final EmploymentHistoryAdapter employmentHistoryAdapter;
    private final IBackendNotifier frontendNotifier;
    private final boolean isArizonaType;
    private boolean isEmptyHistory;
    private boolean isEmptyTasks;
    private final ConstraintLayout screen;
    private final SharedPreferences sharedPref;
    private TaskAdapter taskAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmploymentTaskScreen(final Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.employment_tasks_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screen = constraintLayout;
        EmploymentTasksScreenBinding bind = EmploymentTasksScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        this.employmentHistoryAdapter = new EmploymentHistoryAdapter();
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        this.currentMemberName = "";
        addViewToConstraintLayout(constraintLayout, -1, -1);
        UtilsKt.checkItemsName(targetActivity, z);
        initAdapters();
        bind.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$0(EmploymentTaskScreen.this, targetActivity, view);
            }
        });
        bind.btnHistory.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$1(EmploymentTaskScreen.this, targetActivity, view);
            }
        });
        bind.btnStats.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$2(EmploymentTaskScreen.this, view);
            }
        });
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen.this.closeScreen();
            }
        });
        bind.btnUpdate.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$4(EmploymentTaskScreen.this, view);
            }
        });
        bind.itemTaskInfo.itemInfo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$5(EmploymentTaskScreen.this, view);
            }
        });
        bind.itemTaskInfo.itemRespect.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$6(EmploymentTaskScreen.this, view);
            }
        });
        bind.itemTaskInfo.itemLevelInfo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$7(EmploymentTaskScreen.this, view);
            }
        });
        bind.itemTaskInfo.itemBonus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$8(EmploymentTaskScreen.this, view);
            }
        });
        bind.itemTaskInfo.itemBlacklist.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$9(EmploymentTaskScreen.this, view);
            }
        });
        bind.itemTaskInfo.itemPension.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentTaskScreen._init_$lambda$10(EmploymentTaskScreen.this, view);
            }
        });
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(EmploymentTaskScreen employmentTaskScreen, Activity activity, View view) {
        employmentTaskScreen.screenButtonStatus(0);
        employmentTaskScreen.isVisibleHistoryLayout(false);
        ConstraintLayout parentLayout = employmentTaskScreen.binding.itemTaskInfo.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        employmentTaskScreen.binding.tvTitleTable.setText(activity.getResources().getString(R.string.task_for_upgrade));
        LinearLayout linearTaskStatus = employmentTaskScreen.binding.linearTaskStatus;
        Intrinsics.checkNotNullExpressionValue(linearTaskStatus, "linearTaskStatus");
        linearTaskStatus.setVisibility(!employmentTaskScreen.isEmptyTasks ? 0 : 8);
        if (employmentTaskScreen.isEmptyTasks) {
            ShapeableImageView ivNoFraction = employmentTaskScreen.binding.ivNoFraction;
            Intrinsics.checkNotNullExpressionValue(ivNoFraction, "ivNoFraction");
            ivNoFraction.setVisibility(0);
            MaterialTextView tvNoFraction = employmentTaskScreen.binding.tvNoFraction;
            Intrinsics.checkNotNullExpressionValue(tvNoFraction, "tvNoFraction");
            tvNoFraction.setVisibility(0);
            TextView tvTitleTable = employmentTaskScreen.binding.tvTitleTable;
            Intrinsics.checkNotNullExpressionValue(tvTitleTable, "tvTitleTable");
            tvTitleTable.setVisibility(8);
            TextView tvTitleRankName = employmentTaskScreen.binding.tvTitleRankName;
            Intrinsics.checkNotNullExpressionValue(tvTitleRankName, "tvTitleRankName");
            tvTitleRankName.setVisibility(8);
            employmentTaskScreen.binding.tvNoFraction.setText(activity.getString(R.string.not_in_fraction));
            return;
        }
        ShapeableImageView ivNoFraction2 = employmentTaskScreen.binding.ivNoFraction;
        Intrinsics.checkNotNullExpressionValue(ivNoFraction2, "ivNoFraction");
        ivNoFraction2.setVisibility(8);
        MaterialTextView tvNoFraction2 = employmentTaskScreen.binding.tvNoFraction;
        Intrinsics.checkNotNullExpressionValue(tvNoFraction2, "tvNoFraction");
        tvNoFraction2.setVisibility(8);
        TextView tvTitleTable2 = employmentTaskScreen.binding.tvTitleTable;
        Intrinsics.checkNotNullExpressionValue(tvTitleTable2, "tvTitleTable");
        tvTitleTable2.setVisibility(0);
        TextView tvTitleRankName2 = employmentTaskScreen.binding.tvTitleRankName;
        Intrinsics.checkNotNullExpressionValue(tvTitleRankName2, "tvTitleRankName");
        tvTitleRankName2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(EmploymentTaskScreen employmentTaskScreen, Activity activity, View view) {
        ConstraintLayout parentLayout = employmentTaskScreen.binding.itemTaskInfo.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        employmentTaskScreen.screenButtonStatus(1);
        employmentTaskScreen.isVisibleHistoryLayout(true);
        employmentTaskScreen.binding.tvTitleTable.setText(activity.getResources().getString(R.string.history));
        employmentTaskScreen.sendData(StringKt.toStringJson(""), 0);
        ProgressBar progressBar = employmentTaskScreen.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(0);
        TextView tvTitleTable = employmentTaskScreen.binding.tvTitleTable;
        Intrinsics.checkNotNullExpressionValue(tvTitleTable, "tvTitleTable");
        tvTitleTable.setVisibility(0);
        if (!employmentTaskScreen.isEmptyHistory) {
            ShapeableImageView ivNoFraction = employmentTaskScreen.binding.ivNoFraction;
            Intrinsics.checkNotNullExpressionValue(ivNoFraction, "ivNoFraction");
            ivNoFraction.setVisibility(8);
            MaterialTextView tvNoFraction = employmentTaskScreen.binding.tvNoFraction;
            Intrinsics.checkNotNullExpressionValue(tvNoFraction, "tvNoFraction");
            tvNoFraction.setVisibility(8);
        }
        employmentTaskScreen.binding.tvTitleTable.setText("История");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(EmploymentTaskScreen employmentTaskScreen, View view) {
        employmentTaskScreen.sendData(StringKt.toStringJson(""), 3);
        employmentTaskScreen.screenButtonStatus(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(EmploymentTaskScreen employmentTaskScreen, View view) {
        employmentTaskScreen.sendData(StringKt.toStringJson(""), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(EmploymentTaskScreen employmentTaskScreen, View view) {
        employmentTaskScreen.sendData(StringKt.toStringJson(new DataRequest(0)), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(EmploymentTaskScreen employmentTaskScreen, View view) {
        employmentTaskScreen.sendData(StringKt.toStringJson(new DataRequest(1)), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(EmploymentTaskScreen employmentTaskScreen, View view) {
        employmentTaskScreen.sendData(StringKt.toStringJson(new DataRequest(2)), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$8(EmploymentTaskScreen employmentTaskScreen, View view) {
        employmentTaskScreen.sendData(StringKt.toStringJson(new DataRequest(3)), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$9(EmploymentTaskScreen employmentTaskScreen, View view) {
        employmentTaskScreen.sendData(StringKt.toStringJson(new DataRequest(4)), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$10(EmploymentTaskScreen employmentTaskScreen, View view) {
        employmentTaskScreen.sendData(StringKt.toStringJson(new DataRequest(5)), 4);
    }

    private final void initAdapters() {
        this.binding.rvEmploymentHistory.setAdapter(this.employmentHistoryAdapter);
        this.taskAdapter = new TaskAdapter(getTargetActivity(), new Function2() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initAdapters$lambda$11;
                initAdapters$lambda$11 = EmploymentTaskScreen.initAdapters$lambda$11(EmploymentTaskScreen.this, (TaskInfo) obj, ((Integer) obj2).intValue());
                return initAdapters$lambda$11;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initAdapters$lambda$12;
                initAdapters$lambda$12 = EmploymentTaskScreen.initAdapters$lambda$12(EmploymentTaskScreen.this, (FractionTasks) obj);
                return initAdapters$lambda$12;
            }
        });
        RecyclerView recyclerView = this.binding.rvEmploymentTasks;
        TaskAdapter taskAdapter = this.taskAdapter;
        if (taskAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
            taskAdapter = null;
        }
        recyclerView.setAdapter(taskAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initAdapters$lambda$11(EmploymentTaskScreen employmentTaskScreen, TaskInfo item, int i) {
        TaskAdapter taskAdapter;
        TaskAdapter taskAdapter2;
        TaskAdapter taskAdapter3;
        TaskAdapter taskAdapter4;
        Intrinsics.checkNotNullParameter(item, "item");
        TaskAdapter taskAdapter5 = employmentTaskScreen.taskAdapter;
        TaskAdapter taskAdapter6 = null;
        if (taskAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
            taskAdapter5 = null;
        }
        int selectedItemPosition = taskAdapter5.getSelectedItemPosition();
        if (i == selectedItemPosition) {
            TaskAdapter taskAdapter7 = employmentTaskScreen.taskAdapter;
            if (taskAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
                taskAdapter7 = null;
            }
            if (taskAdapter7.getExpandedViewVisible()) {
                TaskAdapter taskAdapter8 = employmentTaskScreen.taskAdapter;
                if (taskAdapter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
                    taskAdapter8 = null;
                }
                taskAdapter8.setExpandedViewVisible(false);
                taskAdapter = employmentTaskScreen.taskAdapter;
                if (taskAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
                    taskAdapter = null;
                }
                taskAdapter.notifyDataSetChanged();
                taskAdapter2 = employmentTaskScreen.taskAdapter;
                if (taskAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
                    taskAdapter2 = null;
                }
                taskAdapter2.setSelectedItemPosition(i);
                taskAdapter3 = employmentTaskScreen.taskAdapter;
                if (taskAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
                    taskAdapter3 = null;
                }
                taskAdapter3.notifyItemChanged(selectedItemPosition);
                taskAdapter4 = employmentTaskScreen.taskAdapter;
                if (taskAdapter4 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
                } else {
                    taskAdapter6 = taskAdapter4;
                }
                taskAdapter6.notifyItemChanged(i);
                return Unit.INSTANCE;
            }
        }
        TaskAdapter taskAdapter9 = employmentTaskScreen.taskAdapter;
        if (taskAdapter9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
            taskAdapter9 = null;
        }
        taskAdapter9.setExpandedViewVisible(i == selectedItemPosition);
        taskAdapter = employmentTaskScreen.taskAdapter;
        if (taskAdapter == null) {
        }
        taskAdapter.notifyDataSetChanged();
        taskAdapter2 = employmentTaskScreen.taskAdapter;
        if (taskAdapter2 == null) {
        }
        taskAdapter2.setSelectedItemPosition(i);
        taskAdapter3 = employmentTaskScreen.taskAdapter;
        if (taskAdapter3 == null) {
        }
        taskAdapter3.notifyItemChanged(selectedItemPosition);
        taskAdapter4 = employmentTaskScreen.taskAdapter;
        if (taskAdapter4 != null) {
        }
        taskAdapter6.notifyItemChanged(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAdapters$lambda$12(EmploymentTaskScreen employmentTaskScreen, FractionTasks it) {
        Intrinsics.checkNotNullParameter(it, "it");
        employmentTaskScreen.sendData(StringKt.toStringJson(String.valueOf(it.getId())), 1);
        return Unit.INSTANCE;
    }

    private final void screenButtonStatus(int i) {
        if (i == 0) {
            this.binding.btnMenu.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_menu_white));
            this.binding.btnHistory.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_history_black));
            this.binding.btnStats.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_note_black));
        } else if (i == 1) {
            this.binding.btnMenu.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_menu_black));
            this.binding.btnHistory.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_history_white));
            this.binding.btnStats.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_note_black));
        } else if (i != 2) {
        } else {
            this.binding.btnMenu.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_menu_black));
            this.binding.btnHistory.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_history_black));
            this.binding.btnStats.setBackground(getTargetActivity().getResources().getDrawable(R.drawable.btn_note_white));
        }
    }

    private final void showDefaultEmptyFractionView() {
        RecyclerView rvEmploymentTasks = this.binding.rvEmploymentTasks;
        Intrinsics.checkNotNullExpressionValue(rvEmploymentTasks, "rvEmploymentTasks");
        rvEmploymentTasks.setVisibility(8);
        RecyclerView rvEmploymentHistory = this.binding.rvEmploymentHistory;
        Intrinsics.checkNotNullExpressionValue(rvEmploymentHistory, "rvEmploymentHistory");
        rvEmploymentHistory.setVisibility(8);
        ConstraintLayout parentLayout = this.binding.itemTopTable.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        TextView tvTitleTable = this.binding.tvTitleTable;
        Intrinsics.checkNotNullExpressionValue(tvTitleTable, "tvTitleTable");
        tvTitleTable.setVisibility(8);
        TextView tvTitleRankName = this.binding.tvTitleRankName;
        Intrinsics.checkNotNullExpressionValue(tvTitleRankName, "tvTitleRankName");
        tvTitleRankName.setVisibility(8);
        AppCompatButton btnUpdate = this.binding.btnUpdate;
        Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
        btnUpdate.setVisibility(8);
        LinearLayout linearTaskStatus = this.binding.linearTaskStatus;
        Intrinsics.checkNotNullExpressionValue(linearTaskStatus, "linearTaskStatus");
        linearTaskStatus.setVisibility(8);
        MaterialTextView tvNoFraction = this.binding.tvNoFraction;
        Intrinsics.checkNotNullExpressionValue(tvNoFraction, "tvNoFraction");
        tvNoFraction.setVisibility(0);
        ShapeableImageView ivNoFraction = this.binding.ivNoFraction;
        Intrinsics.checkNotNullExpressionValue(ivNoFraction, "ivNoFraction");
        ivNoFraction.setVisibility(0);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        ArrayList arrayList;
        List<TaskInfo> tasks;
        TaskStats taskStats;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_EMPL", "subiD: " + i + " ==== data: " + data);
        if (i != 0) {
            if (i != 1) {
                if (i == 2 && (taskStats = (TaskStats) MapperKt.jsonToModel(data, TaskStats.class, getBackendID(), getTargetActivity(), getNotifier())) != null) {
                    showTaskStats(taskStats);
                    blockClickable(taskStats.getViewMode());
                    return;
                }
                return;
            }
            List listModel = MapperKt.toListModel(data, TaskHistory.class);
            if (listModel.isEmpty()) {
                this.isEmptyHistory = true;
                showDefaultEmptyFractionView();
                this.binding.tvFractionName.setText("Нет данных");
                this.binding.ivNoFraction.setImageResource(R.drawable.bg_no_history);
                this.binding.tvNoFraction.setText("История отсутствует");
                return;
            }
            this.isEmptyHistory = false;
            List list = listModel;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Object obj : list) {
                int i2 = r6 + 1;
                if (r6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add(TaskHistory.copy$default((TaskHistory) obj, Integer.valueOf(i2), null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
                r6 = i2;
            }
            ProgressBar progressBar = this.binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
            progressBar.setVisibility(8);
            this.employmentHistoryAdapter.submitList(arrayList2);
            return;
        }
        Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) TaskListResponse.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        TaskListResponse taskListResponse = (TaskListResponse) fromJson;
        if (taskListResponse.getMember() >= 1) {
            this.isEmptyTasks = false;
            screenButtonStatus(0);
            isVisibleHistoryLayout(false);
            showTasksUi(taskListResponse);
            List<TaskInfo> tasks2 = taskListResponse.getTasks();
            if (tasks2 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : tasks2) {
                    if (((TaskInfo) obj2).getCompleted() == 1) {
                        arrayList3.add(obj2);
                    }
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            this.binding.tvTasksDone.setText(String.valueOf(arrayList != null ? Integer.valueOf(arrayList.size()) : null));
            this.binding.tvTasksRemain.setText("/ " + (taskListResponse.getTasks() != null ? Integer.valueOf(tasks.size()) : null));
            ProgressBar progressBar2 = this.binding.progressBar;
            List<TaskInfo> tasks3 = taskListResponse.getTasks();
            progressBar2.setMax(tasks3 != null ? tasks3.size() : 0);
            this.binding.progressBar.setProgress(arrayList != null ? arrayList.size() : 0);
            String backgroundImage = taskListResponse.getBackgroundImage();
            this.binding.parentLayout.setBackgroundResource(getTargetActivity().getResources().getIdentifier(backgroundImage != null ? StringsKt.substringBeforeLast$default(backgroundImage, ".", (String) null, 2, (Object) null) : null, "drawable", getTargetActivity().getPackageName()));
            return;
        }
        showDefaultEmptyFractionView();
        this.binding.tvFractionName.setText("Нет данных");
        this.binding.parentLayout.setBackgroundResource(getTargetActivity().getResources().getIdentifier("none", "drawable", getTargetActivity().getPackageName()));
        this.isEmptyTasks = true;
    }

    private final LayoutEmploymentInfoBinding showTaskStats(TaskStats taskStats) {
        LayoutEmploymentInfoBinding layoutEmploymentInfoBinding;
        EmploymentTasksScreenBinding employmentTasksScreenBinding = this.binding;
        showDefaultEmptyFractionView();
        MaterialTextView tvNoFraction = employmentTasksScreenBinding.tvNoFraction;
        Intrinsics.checkNotNullExpressionValue(tvNoFraction, "tvNoFraction");
        tvNoFraction.setVisibility(8);
        ShapeableImageView ivNoFraction = employmentTasksScreenBinding.ivNoFraction;
        Intrinsics.checkNotNullExpressionValue(ivNoFraction, "ivNoFraction");
        ivNoFraction.setVisibility(8);
        TextView tvTitle = employmentTasksScreenBinding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
        tvTitle.setVisibility(0);
        if (this.currentMemberName.length() == 0) {
            employmentTasksScreenBinding.tvFractionName.setText("Нет данных");
            LinearLayout linearTaskStatus = employmentTasksScreenBinding.linearTaskStatus;
            Intrinsics.checkNotNullExpressionValue(linearTaskStatus, "linearTaskStatus");
            linearTaskStatus.setVisibility(8);
        } else {
            employmentTasksScreenBinding.tvFractionName.setText(this.currentMemberName);
            LinearLayout linearTaskStatus2 = employmentTasksScreenBinding.linearTaskStatus;
            Intrinsics.checkNotNullExpressionValue(linearTaskStatus2, "linearTaskStatus");
            linearTaskStatus2.setVisibility(0);
        }
        TextView tvFractionName = employmentTasksScreenBinding.tvFractionName;
        Intrinsics.checkNotNullExpressionValue(tvFractionName, "tvFractionName");
        tvFractionName.setVisibility(0);
        ConstraintLayout parentLayout = employmentTasksScreenBinding.itemTaskInfo.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(0);
        employmentTasksScreenBinding.itemTaskInfo.tvTitleItem.setText(taskStats.getUserName());
        employmentTasksScreenBinding.itemTaskInfo.tvHours.setText(String.valueOf(taskStats.getHoursPlayed()));
        employmentTasksScreenBinding.itemTaskInfo.tvRespectCount.setText(String.valueOf(taskStats.getRespectsCount()));
        employmentTasksScreenBinding.itemTaskInfo.tvLevel.setText(String.valueOf(taskStats.getPrivilegesLevel()));
        employmentTasksScreenBinding.itemTaskInfo.tvLevelMax.setText("/ " + taskStats.getMaxPrivilegesLevel());
        if (taskStats.getPrivilegeStatusMax() != null && taskStats.getPrivilegeStatusCurrent() != null) {
            employmentTasksScreenBinding.itemTaskInfo.progressBar.setMax(taskStats.getBenefitLevelProgressMax());
            employmentTasksScreenBinding.itemTaskInfo.progressBar.setProgress(taskStats.getBenefitLevelProgress());
        } else {
            employmentTasksScreenBinding.itemTaskInfo.progressBar.setMax(taskStats.getMaxPrivilegesLevel());
            employmentTasksScreenBinding.itemTaskInfo.progressBar.setProgress(taskStats.getPrivilegesLevel());
        }
        employmentTasksScreenBinding.itemTaskInfo.progressBar.setVisibility(0);
        if (taskStats.getPrivilegeStatusMax() != null && taskStats.getPrivilegeStatusCurrent() != null) {
            layoutEmploymentInfoBinding = employmentTasksScreenBinding.itemTaskInfo;
            layoutEmploymentInfoBinding.progressThunderContainer.setVisibility(0);
            layoutEmploymentInfoBinding.progressBarThunder.setMax(taskStats.getPrivilegeStatusMax().intValue());
            layoutEmploymentInfoBinding.progressBarThunder.setProgress(taskStats.getPrivilegeStatusCurrent().intValue());
            layoutEmploymentInfoBinding.progressBarThunder.setVisibility(0);
            layoutEmploymentInfoBinding.tvLevelThunder.setText(taskStats.getPrivilegeStatusCurrent().toString());
            layoutEmploymentInfoBinding.tvLevelMaxThunder.setText("/ " + taskStats.getPrivilegeStatusMax());
            layoutEmploymentInfoBinding.tvThunderDescription.setText("Состояние моей льготы");
            layoutEmploymentInfoBinding.ivEllipseThunder.setVisibility(8);
            layoutEmploymentInfoBinding.progressBarThunder.setVisibility(0);
        } else {
            layoutEmploymentInfoBinding = employmentTasksScreenBinding.itemTaskInfo;
            layoutEmploymentInfoBinding.ivEllipseThunder.setVisibility(0);
            layoutEmploymentInfoBinding.progressThunderContainer.setVisibility(8);
            layoutEmploymentInfoBinding.progressBarThunder.setVisibility(8);
            layoutEmploymentInfoBinding.tvThunderDescription.setText("Бонусы за нахождение в организации");
        }
        Intrinsics.checkNotNullExpressionValue(layoutEmploymentInfoBinding, "with(...)");
        return layoutEmploymentInfoBinding;
    }

    private final void blockClickable(boolean z) {
        EmploymentTasksScreenBinding employmentTasksScreenBinding = this.binding;
        View viewLockedItemInfo = employmentTasksScreenBinding.itemTaskInfo.viewLockedItemInfo;
        Intrinsics.checkNotNullExpressionValue(viewLockedItemInfo, "viewLockedItemInfo");
        viewLockedItemInfo.setVisibility(z ? 0 : 8);
        ImageView ivLockItemInfo = employmentTasksScreenBinding.itemTaskInfo.ivLockItemInfo;
        Intrinsics.checkNotNullExpressionValue(ivLockItemInfo, "ivLockItemInfo");
        ivLockItemInfo.setVisibility(z ? 0 : 8);
        employmentTasksScreenBinding.itemTaskInfo.itemInfo.setClickable(!z);
        View viewLockedRespect = employmentTasksScreenBinding.itemTaskInfo.viewLockedRespect;
        Intrinsics.checkNotNullExpressionValue(viewLockedRespect, "viewLockedRespect");
        viewLockedRespect.setVisibility(z ? 0 : 8);
        ImageView ivLockRespect = employmentTasksScreenBinding.itemTaskInfo.ivLockRespect;
        Intrinsics.checkNotNullExpressionValue(ivLockRespect, "ivLockRespect");
        ivLockRespect.setVisibility(z ? 0 : 8);
        employmentTasksScreenBinding.itemTaskInfo.itemRespect.setClickable(!z);
        View viewLockedBonus = employmentTasksScreenBinding.itemTaskInfo.viewLockedBonus;
        Intrinsics.checkNotNullExpressionValue(viewLockedBonus, "viewLockedBonus");
        viewLockedBonus.setVisibility(z ? 0 : 8);
        ImageView ivLockItemBonus = employmentTasksScreenBinding.itemTaskInfo.ivLockItemBonus;
        Intrinsics.checkNotNullExpressionValue(ivLockItemBonus, "ivLockItemBonus");
        ivLockItemBonus.setVisibility(z ? 0 : 8);
        employmentTasksScreenBinding.itemTaskInfo.itemBonus.setClickable(!z);
        View viewLockedLevelInfo = employmentTasksScreenBinding.itemTaskInfo.viewLockedLevelInfo;
        Intrinsics.checkNotNullExpressionValue(viewLockedLevelInfo, "viewLockedLevelInfo");
        viewLockedLevelInfo.setVisibility(z ? 0 : 8);
        ImageView ivLockLevelInfo = employmentTasksScreenBinding.itemTaskInfo.ivLockLevelInfo;
        Intrinsics.checkNotNullExpressionValue(ivLockLevelInfo, "ivLockLevelInfo");
        ivLockLevelInfo.setVisibility(z ? 0 : 8);
        employmentTasksScreenBinding.itemTaskInfo.itemLevelInfo.setClickable(!z);
        View viewLockedPension = employmentTasksScreenBinding.itemTaskInfo.viewLockedPension;
        Intrinsics.checkNotNullExpressionValue(viewLockedPension, "viewLockedPension");
        viewLockedPension.setVisibility(z ? 0 : 8);
        ImageView ivLockItemPension = employmentTasksScreenBinding.itemTaskInfo.ivLockItemPension;
        Intrinsics.checkNotNullExpressionValue(ivLockItemPension, "ivLockItemPension");
        ivLockItemPension.setVisibility(z ? 0 : 8);
        employmentTasksScreenBinding.itemTaskInfo.itemPension.setClickable(!z);
    }

    private final void showTasksUi(TaskListResponse taskListResponse) {
        this.currentMemberName = String.valueOf(taskListResponse.getMemberName());
        this.binding.tvFractionName.setText(this.currentMemberName);
        this.binding.tvTitleRankName.setText(taskListResponse.getRankName());
        AppCompatButton btnUpdate = this.binding.btnUpdate;
        Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
        AppCompatButton appCompatButton = btnUpdate;
        Integer isUpgrade = taskListResponse.isUpgrade();
        appCompatButton.setVisibility(isUpgrade == null || isUpgrade.intValue() != 0 ? 0 : 8);
        TaskAdapter taskAdapter = this.taskAdapter;
        if (taskAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
            taskAdapter = null;
        }
        taskAdapter.submitList(taskListResponse.getTasks());
    }

    private final void isVisibleHistoryLayout(boolean z) {
        RecyclerView rvEmploymentTasks = this.binding.rvEmploymentTasks;
        Intrinsics.checkNotNullExpressionValue(rvEmploymentTasks, "rvEmploymentTasks");
        rvEmploymentTasks.setVisibility(!z ? 0 : 8);
        ConstraintLayout parentLayout = this.binding.itemTopTable.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(z ? 0 : 8);
        RecyclerView rvEmploymentHistory = this.binding.rvEmploymentHistory;
        Intrinsics.checkNotNullExpressionValue(rvEmploymentHistory, "rvEmploymentHistory");
        rvEmploymentHistory.setVisibility(z ? 0 : 8);
        LinearLayout linearTaskStatus = this.binding.linearTaskStatus;
        Intrinsics.checkNotNullExpressionValue(linearTaskStatus, "linearTaskStatus");
        linearTaskStatus.setVisibility(!z ? 0 : 8);
        TextView tvTitleRankName = this.binding.tvTitleRankName;
        Intrinsics.checkNotNullExpressionValue(tvTitleRankName, "tvTitleRankName");
        tvTitleRankName.setVisibility(!z ? 0 : 8);
        TextView tvTitleTable = this.binding.tvTitleTable;
        Intrinsics.checkNotNullExpressionValue(tvTitleTable, "tvTitleTable");
        tvTitleTable.setVisibility(!z ? 0 : 8);
        TextView tvTitle = this.binding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
        tvTitle.setVisibility(!z ? 0 : 8);
        TextView tvFractionName = this.binding.tvFractionName;
        Intrinsics.checkNotNullExpressionValue(tvFractionName, "tvFractionName");
        tvFractionName.setVisibility(z ? 8 : 0);
    }

    private final void sendData(String str, int i) {
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.EMPLOYMENT_TASK.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.EMPLOYMENT_TASK.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    /* compiled from: EmploymentTaskScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/presentation/EmploymentTaskScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new EmploymentTaskScreen(targetActivity, i);
        }
    }
}
