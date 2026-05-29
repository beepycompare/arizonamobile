package ru.mrlargha.commonui.elements.quest.presentation;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.SeasonalRodinaQuestScreenBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.quest.domain.ActivityDoneInfo;
import ru.mrlargha.commonui.elements.quest.domain.ActivityQuestResponse;
import ru.mrlargha.commonui.elements.quest.domain.QuestBackgroundType;
import ru.mrlargha.commonui.elements.quest.domain.QuestStage;
import ru.mrlargha.commonui.elements.quest.domain.QuestTask;
import ru.mrlargha.commonui.elements.quest.domain.QuestTaskRequest;
import ru.mrlargha.commonui.elements.quest.presentation.adapter.QuestActivityAdapter;
import ru.mrlargha.commonui.elements.quest.presentation.adapter.QuestStageAdapter;
import ru.mrlargha.commonui.elements.quest.presentation.adapter.QuestTaskAdapter;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: NewQuestScreen.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u00014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0002J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u001eH\u0002J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020 H\u0002J\u0018\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\u0016\u0010/\u001a\u00020\u001e2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001b01H\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u0006H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/NewQuestScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "questScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/SeasonalRodinaQuestScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "mainHandler", "Landroid/os/Handler;", "submitQuestTasksRunnable", "Ljava/lang/Runnable;", "questActivityAdapter", "Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestActivityAdapter;", "questStageAdapter", "Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestStageAdapter;", "questTaskAdapter", "Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter;", "questTaskList", "", "Lru/mrlargha/commonui/elements/quest/domain/QuestTask;", "backgroundId", "setVisible", "", "visible", "", "initAdapters", "onBackendMessageHandled", "data", "", "subId", "changeBackground", "firstInterfaceVisibility", "isVisible", "secondInterfaceVisibility", "sendData", "indexKey", "closeScreen", "scheduleQuestTaskSubmit", "cancelPendingQuestTaskUpdates", "submitQuestTasks", "tasks", "", "notifyQuestTaskChanged", "position", "Spawner", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NewQuestScreen extends SAMPUIElement implements InterfaceController {
    private int backgroundId;
    private final SeasonalRodinaQuestScreenBinding binding;
    private final IBackendNotifier frontendNotifier;
    private final Handler mainHandler;
    private final QuestActivityAdapter questActivityAdapter;
    private final ConstraintLayout questScreen;
    private final QuestStageAdapter questStageAdapter;
    private QuestTaskAdapter questTaskAdapter;
    private List<QuestTask> questTaskList;
    private final Runnable submitQuestTasksRunnable;

    /* compiled from: NewQuestScreen.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[QuestBackgroundType.values().length];
            try {
                iArr[QuestBackgroundType.NIGHT_OF_JUDGMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QuestBackgroundType.RODINA_BIRTHDAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QuestBackgroundType.HALLOWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[QuestBackgroundType.HALLOWEEN_DARK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[QuestBackgroundType.NEW_YEAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[QuestBackgroundType.BUSINESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewQuestScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.seasonal_rodina_quest_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.questScreen = constraintLayout;
        SeasonalRodinaQuestScreenBinding bind = SeasonalRodinaQuestScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.submitQuestTasksRunnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.quest.presentation.NewQuestScreen$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                r0.submitQuestTasks(NewQuestScreen.this.questTaskList);
            }
        };
        this.questActivityAdapter = new QuestActivityAdapter();
        this.questStageAdapter = new QuestStageAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.quest.presentation.NewQuestScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NewQuestScreen.questStageAdapter$lambda$0(NewQuestScreen.this, (QuestStage) obj);
            }
        });
        this.questTaskList = new ArrayList();
        addViewToConstraintLayout(constraintLayout, -1, -1);
        initAdapters();
        bind.ivGetQuest.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.presentation.NewQuestScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewQuestScreen.this.sendData(0, "");
            }
        });
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.presentation.NewQuestScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewQuestScreen._init_$lambda$1(NewQuestScreen.this, view);
            }
        });
        bind.btnExit.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.presentation.NewQuestScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewQuestScreen.this.closeScreen();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit questStageAdapter$lambda$0(NewQuestScreen newQuestScreen, QuestStage item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ArrayList arrayList = new ArrayList();
        for (Object obj : newQuestScreen.questTaskList) {
            if (((QuestTask) obj).getStageId() == item.getId()) {
                arrayList.add(obj);
            }
        }
        newQuestScreen.submitQuestTasks(arrayList);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        if (!z) {
            cancelPendingQuestTaskUpdates();
            this.binding.rvQuestTasks.stopScroll();
        }
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$1(NewQuestScreen newQuestScreen, View view) {
        newQuestScreen.questTaskList.clear();
        newQuestScreen.submitQuestTasks(CollectionsKt.emptyList());
        newQuestScreen.sendData(1, "");
    }

    private final void initAdapters() {
        this.binding.rvQuestActivity.setAdapter(this.questActivityAdapter);
        this.binding.rvQuestStages.setAdapter(this.questStageAdapter);
        this.questTaskAdapter = new QuestTaskAdapter(getTargetActivity(), new Function2() { // from class: ru.mrlargha.commonui.elements.quest.presentation.NewQuestScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NewQuestScreen.initAdapters$lambda$0(NewQuestScreen.this, (QuestTask) obj, ((Integer) obj2).intValue());
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.quest.presentation.NewQuestScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NewQuestScreen.initAdapters$lambda$1(NewQuestScreen.this, (QuestTask) obj);
            }
        });
        RecyclerView recyclerView = this.binding.rvQuestTasks;
        QuestTaskAdapter questTaskAdapter = this.questTaskAdapter;
        if (questTaskAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
            questTaskAdapter = null;
        }
        recyclerView.setAdapter(questTaskAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initAdapters$lambda$0(NewQuestScreen newQuestScreen, QuestTask item, int i) {
        QuestTaskAdapter questTaskAdapter;
        Intrinsics.checkNotNullParameter(item, "item");
        QuestTaskAdapter questTaskAdapter2 = newQuestScreen.questTaskAdapter;
        QuestTaskAdapter questTaskAdapter3 = null;
        if (questTaskAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
            questTaskAdapter2 = null;
        }
        int selectedItemPosition = questTaskAdapter2.getSelectedItemPosition();
        if (i == selectedItemPosition) {
            QuestTaskAdapter questTaskAdapter4 = newQuestScreen.questTaskAdapter;
            if (questTaskAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
                questTaskAdapter4 = null;
            }
            if (questTaskAdapter4.getExpandedViewVisible()) {
                QuestTaskAdapter questTaskAdapter5 = newQuestScreen.questTaskAdapter;
                if (questTaskAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
                    questTaskAdapter5 = null;
                }
                questTaskAdapter5.setExpandedViewVisible(false);
                questTaskAdapter = newQuestScreen.questTaskAdapter;
                if (questTaskAdapter != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
                } else {
                    questTaskAdapter3 = questTaskAdapter;
                }
                questTaskAdapter3.setSelectedItemPosition(i);
                newQuestScreen.notifyQuestTaskChanged(selectedItemPosition);
                newQuestScreen.notifyQuestTaskChanged(i);
                return Unit.INSTANCE;
            }
        }
        QuestTaskAdapter questTaskAdapter6 = newQuestScreen.questTaskAdapter;
        if (questTaskAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
            questTaskAdapter6 = null;
        }
        questTaskAdapter6.setExpandedViewVisible(i == selectedItemPosition);
        questTaskAdapter = newQuestScreen.questTaskAdapter;
        if (questTaskAdapter != null) {
        }
        questTaskAdapter3.setSelectedItemPosition(i);
        newQuestScreen.notifyQuestTaskChanged(selectedItemPosition);
        newQuestScreen.notifyQuestTaskChanged(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit initAdapters$lambda$1(NewQuestScreen newQuestScreen, QuestTask item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getProgress() == item.getMaxProgress() && item.getRewardReceived() == 0) {
            newQuestScreen.sendData(3, StringKt.toStringJson(new QuestTaskRequest(item.getStageId(), item.getId())));
        } else if (item.getProgress() != item.getMaxProgress() || item.getRewardReceived() != 1) {
            newQuestScreen.sendData(2, StringKt.toStringJson(new QuestTaskRequest(item.getStageId(), item.getId())));
            QuestTaskAdapter questTaskAdapter = newQuestScreen.questTaskAdapter;
            QuestTaskAdapter questTaskAdapter2 = null;
            if (questTaskAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
                questTaskAdapter = null;
            }
            int selectedItemPosition = questTaskAdapter.getSelectedItemPosition();
            QuestTaskAdapter questTaskAdapter3 = newQuestScreen.questTaskAdapter;
            if (questTaskAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
            } else {
                questTaskAdapter2 = questTaskAdapter3;
            }
            questTaskAdapter2.setSelectedItemPosition(-1);
            newQuestScreen.notifyQuestTaskChanged(selectedItemPosition);
        }
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            ActivityQuestResponse activityQuestResponse = (ActivityQuestResponse) MapperKt.jsonToModel(data, ActivityQuestResponse.class, getBackendID(), getTargetActivity(), this.frontendNotifier);
            firstInterfaceVisibility(true);
            secondInterfaceVisibility(false);
            this.binding.tvUserName.setText(activityQuestResponse != null ? activityQuestResponse.getName() : null);
            this.questActivityAdapter.submitList(activityQuestResponse != null ? activityQuestResponse.getList() : null);
        } else if (i == 1) {
            List jsonToListModel = MapperKt.jsonToListModel(data, QuestStage.class, getBackendID(), getTargetActivity(), this.frontendNotifier);
            firstInterfaceVisibility(false);
            secondInterfaceVisibility(true);
            this.questStageAdapter.submitList(jsonToListModel);
            scheduleQuestTaskSubmit();
        } else if (i == 2) {
            List jsonToListModel2 = MapperKt.jsonToListModel(data, QuestTask.class, getBackendID(), getTargetActivity(), this.frontendNotifier);
            List<ActivityDoneInfo> mutableList = jsonToListModel2 != null ? CollectionsKt.toMutableList((Collection) jsonToListModel2) : null;
            if (mutableList == null || !(!mutableList.isEmpty())) {
                return;
            }
            List<QuestTask> list = this.questTaskList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                QuestTask questTask = (QuestTask) obj;
                linkedHashMap.put(TuplesKt.to(Integer.valueOf(questTask.getStageId()), Integer.valueOf(questTask.getId())), obj);
            }
            Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
            Iterator<ActivityDoneInfo> it = mutableList.iterator();
            while (it.hasNext()) {
                QuestTask questTask2 = (QuestTask) it.next();
                mutableMap.put(TuplesKt.to(Integer.valueOf(questTask2.getStageId()), Integer.valueOf(questTask2.getId())), questTask2);
            }
            this.questTaskList = CollectionsKt.toMutableList(mutableMap.values());
            scheduleQuestTaskSubmit();
        } else {
            if (i != 3) {
                return;
            }
            this.backgroundId = Integer.parseInt(data);
            changeBackground();
        }
    }

    private final void changeBackground() {
        switch (WhenMappings.$EnumSwitchMapping$0[QuestBackgroundType.Companion.fromQuestType(this.backgroundId).ordinal()]) {
            case 1:
                this.binding.getRoot().setBackgroundResource(R.drawable.bg_quest_test);
                return;
            case 2:
                this.binding.getRoot().setBackgroundResource(R.drawable.background_quests_rodina_birhday);
                return;
            case 3:
                this.binding.getRoot().setBackgroundResource(R.drawable.background_quests_halloween);
                return;
            case 4:
                this.binding.getRoot().setBackgroundResource(R.drawable.background_quests_halloween_dark);
                return;
            case 5:
                this.binding.getRoot().setBackgroundResource(R.drawable.background_quests_new_year);
                return;
            case 6:
                this.binding.getRoot().setBackgroundResource(R.drawable.background_business);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void firstInterfaceVisibility(boolean z) {
        SeasonalRodinaQuestScreenBinding seasonalRodinaQuestScreenBinding = this.binding;
        LinearLayout cvUserName = seasonalRodinaQuestScreenBinding.cvUserName;
        Intrinsics.checkNotNullExpressionValue(cvUserName, "cvUserName");
        cvUserName.setVisibility(z ? 0 : 8);
        RecyclerView rvQuestActivity = seasonalRodinaQuestScreenBinding.rvQuestActivity;
        Intrinsics.checkNotNullExpressionValue(rvQuestActivity, "rvQuestActivity");
        rvQuestActivity.setVisibility(z ? 0 : 8);
        TextView tvGetQuest = seasonalRodinaQuestScreenBinding.tvGetQuest;
        Intrinsics.checkNotNullExpressionValue(tvGetQuest, "tvGetQuest");
        tvGetQuest.setVisibility(z ? 0 : 8);
        ImageView ivGetQuest = seasonalRodinaQuestScreenBinding.ivGetQuest;
        Intrinsics.checkNotNullExpressionValue(ivGetQuest, "ivGetQuest");
        ivGetQuest.setVisibility(z ? 0 : 8);
        if (z) {
            seasonalRodinaQuestScreenBinding.tvTitle.setText("Активность \nна мероприятии");
        }
    }

    private final void secondInterfaceVisibility(boolean z) {
        SeasonalRodinaQuestScreenBinding seasonalRodinaQuestScreenBinding = this.binding;
        ImageView btnBack = seasonalRodinaQuestScreenBinding.btnBack;
        Intrinsics.checkNotNullExpressionValue(btnBack, "btnBack");
        btnBack.setVisibility(z ? 0 : 8);
        TextView tvTitleQuestStages = seasonalRodinaQuestScreenBinding.tvTitleQuestStages;
        Intrinsics.checkNotNullExpressionValue(tvTitleQuestStages, "tvTitleQuestStages");
        tvTitleQuestStages.setVisibility(z ? 0 : 8);
        RecyclerView rvQuestStages = seasonalRodinaQuestScreenBinding.rvQuestStages;
        Intrinsics.checkNotNullExpressionValue(rvQuestStages, "rvQuestStages");
        rvQuestStages.setVisibility(z ? 0 : 8);
        TextView tvTitleQuestTasks = seasonalRodinaQuestScreenBinding.tvTitleQuestTasks;
        Intrinsics.checkNotNullExpressionValue(tvTitleQuestTasks, "tvTitleQuestTasks");
        tvTitleQuestTasks.setVisibility(z ? 0 : 8);
        RecyclerView rvQuestTasks = seasonalRodinaQuestScreenBinding.rvQuestTasks;
        Intrinsics.checkNotNullExpressionValue(rvQuestTasks, "rvQuestTasks");
        rvQuestTasks.setVisibility(z ? 0 : 8);
        if (z) {
            seasonalRodinaQuestScreenBinding.tvTitle.setText("Список заданий");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendData(int i, String str) {
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.RODINA_NEW_QUEST.getId();
        int i2 = this.backgroundId;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, i, i2, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.questTaskList.clear();
        cancelPendingQuestTaskUpdates();
        this.binding.rvQuestTasks.stopScroll();
        submitQuestTasks(CollectionsKt.emptyList());
        this.frontendNotifier.setUIElementVisible(UIElementID.RODINA_NEW_QUEST.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    private final void scheduleQuestTaskSubmit() {
        cancelPendingQuestTaskUpdates();
        this.mainHandler.postDelayed(this.submitQuestTasksRunnable, 300L);
    }

    private final void cancelPendingQuestTaskUpdates() {
        this.mainHandler.removeCallbacks(this.submitQuestTasksRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitQuestTasks(List<QuestTask> list) {
        List list2 = CollectionsKt.toList(list);
        int size = list2.size();
        QuestTaskAdapter questTaskAdapter = this.questTaskAdapter;
        QuestTaskAdapter questTaskAdapter2 = null;
        if (questTaskAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
            questTaskAdapter = null;
        }
        int selectedItemPosition = questTaskAdapter.getSelectedItemPosition();
        if (selectedItemPosition < 0 || selectedItemPosition >= size) {
            QuestTaskAdapter questTaskAdapter3 = this.questTaskAdapter;
            if (questTaskAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
                questTaskAdapter3 = null;
            }
            questTaskAdapter3.setSelectedItemPosition(-1);
            QuestTaskAdapter questTaskAdapter4 = this.questTaskAdapter;
            if (questTaskAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
                questTaskAdapter4 = null;
            }
            questTaskAdapter4.setExpandedViewVisible(false);
        }
        QuestTaskAdapter questTaskAdapter5 = this.questTaskAdapter;
        if (questTaskAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
        } else {
            questTaskAdapter2 = questTaskAdapter5;
        }
        questTaskAdapter2.submitList(list2);
    }

    private final void notifyQuestTaskChanged(int i) {
        if (i >= 0) {
            QuestTaskAdapter questTaskAdapter = this.questTaskAdapter;
            QuestTaskAdapter questTaskAdapter2 = null;
            if (questTaskAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
                questTaskAdapter = null;
            }
            if (i < questTaskAdapter.getItemCount()) {
                QuestTaskAdapter questTaskAdapter3 = this.questTaskAdapter;
                if (questTaskAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("questTaskAdapter");
                } else {
                    questTaskAdapter2 = questTaskAdapter3;
                }
                questTaskAdapter2.notifyItemChanged(i);
            }
        }
    }

    /* compiled from: NewQuestScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/NewQuestScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.RODINA_NEW_QUEST);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new NewQuestScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
