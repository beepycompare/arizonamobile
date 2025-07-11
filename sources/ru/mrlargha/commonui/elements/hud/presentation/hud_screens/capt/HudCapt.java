package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudCaptBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: HudCapt.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u001e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001e\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCapt;", "", "<init>", "()V", "currentModel", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptModel;", "adapter", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemAdapter;", "timerJob", "Lkotlinx/coroutines/Job;", "closeListJob", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isOpenCapt", "", "isOpenList", "showCapt", "", "binding", "Lru/mrlargha/commonui/databinding/HudCaptBinding;", "data", "", "initialize", CommonUrlParts.MODEL, "updateCurrentModel", "checkListCount", "itemList", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemModel;", "setOnClickListeners", "checkOpenList", "startTimer", "time", "", "closeListAfterFiveSecond", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudCapt {
    private static Job closeListJob;
    private static HudCaptModel currentModel;
    private static boolean isOpenCapt;
    private static boolean isOpenList;
    private static Job timerJob;
    public static final HudCapt INSTANCE = new HudCapt();
    private static final HudCaptItemAdapter adapter = new HudCaptItemAdapter();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    private HudCapt() {
    }

    public final void showCapt(HudCaptBinding binding, String data) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.length() > 0) {
            try {
                HudCaptModel hudCaptModel = (HudCaptModel) MapperKt.toModel(data, HudCaptModel.class);
                if (currentModel == null) {
                    HudCapt hudCapt = INSTANCE;
                    currentModel = hudCaptModel;
                    if (!isOpenCapt) {
                        isOpenCapt = true;
                        hudCapt.initialize(binding, hudCaptModel);
                        return;
                    }
                    hudCapt.checkListCount(binding, hudCaptModel.getItemList());
                    return;
                }
                HudCapt hudCapt2 = INSTANCE;
                hudCapt2.initialize(binding, hudCapt2.updateCurrentModel(hudCaptModel));
                return;
            } catch (Exception e) {
                Log.d("HUD_CAPT_TAG", data + "  " + e.getMessage());
                e.printStackTrace();
                Toast.makeText(binding.getRoot().getContext(), "Json not valid", 1).show();
                return;
            }
        }
        isOpenCapt = false;
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        Job job = timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    private final void initialize(HudCaptBinding hudCaptBinding, HudCaptModel hudCaptModel) {
        LinearLayout root = hudCaptBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        hudCaptBinding.tvName.setText(hudCaptModel.getName());
        RecyclerView recyclerView = hudCaptBinding.rvItems;
        HudCaptItemAdapter hudCaptItemAdapter = adapter;
        recyclerView.setAdapter(hudCaptItemAdapter);
        Boolean ordinalNumbers = hudCaptModel.getOrdinalNumbers();
        if (ordinalNumbers != null) {
            hudCaptItemAdapter.setShowNumbering(ordinalNumbers.booleanValue());
        }
        hudCaptItemAdapter.setScoreIconType(hudCaptModel.getScoreIconType());
        HudCapt hudCapt = INSTANCE;
        hudCapt.startTimer(hudCaptModel.getTime() * 1000, hudCaptBinding);
        hudCapt.checkListCount(hudCaptBinding, hudCaptModel.getItemList());
    }

    private final HudCaptModel updateCurrentModel(HudCaptModel hudCaptModel) {
        HudCaptModel hudCaptModel2;
        HudCaptModel hudCaptModel3;
        HudCaptModel hudCaptModel4;
        String name = hudCaptModel.getName();
        if (name.length() == 0 && ((hudCaptModel4 = currentModel) == null || (name = hudCaptModel4.getName()) == null)) {
            name = "";
        }
        String str = name;
        long j = 0;
        if (hudCaptModel.getTime() > 0) {
            j = hudCaptModel.getTime();
        } else {
            HudCaptModel hudCaptModel5 = currentModel;
            if (hudCaptModel5 != null) {
                j = hudCaptModel5.getTime();
            }
        }
        Boolean ordinalNumbers = hudCaptModel.getOrdinalNumbers();
        Boolean valueOf = Boolean.valueOf((ordinalNumbers == null && ((hudCaptModel2 = currentModel) == null || (ordinalNumbers = hudCaptModel2.getOrdinalNumbers()) == null)) ? false : ordinalNumbers.booleanValue());
        List<HudCaptItemModel> itemList = hudCaptModel.getItemList();
        if (itemList.isEmpty() && ((hudCaptModel3 = currentModel) == null || (itemList = hudCaptModel3.getItemList()) == null)) {
            itemList = CollectionsKt.emptyList();
        }
        HudCaptModel hudCaptModel6 = new HudCaptModel(str, j, valueOf, itemList, (hudCaptModel.getScoreIcon() > -1 || (hudCaptModel = currentModel) != null) ? hudCaptModel.getScoreIcon() : 0);
        currentModel = hudCaptModel6;
        return hudCaptModel6;
    }

    private final void checkListCount(HudCaptBinding hudCaptBinding, List<HudCaptItemModel> list) {
        if (list.size() > 2) {
            HudCapt hudCapt = INSTANCE;
            hudCapt.checkOpenList(hudCaptBinding, list);
            LinearLayout btnOpenList = hudCaptBinding.btnOpenList;
            Intrinsics.checkNotNullExpressionValue(btnOpenList, "btnOpenList");
            btnOpenList.setVisibility(0);
            hudCapt.setOnClickListeners(hudCaptBinding, list);
            return;
        }
        adapter.submitList(list);
        LinearLayout btnOpenList2 = hudCaptBinding.btnOpenList;
        Intrinsics.checkNotNullExpressionValue(btnOpenList2, "btnOpenList");
        btnOpenList2.setVisibility(8);
    }

    private final void setOnClickListeners(final HudCaptBinding hudCaptBinding, final List<HudCaptItemModel> list) {
        hudCaptBinding.btnOpenList.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HudCapt.setOnClickListeners$lambda$6(HudCaptBinding.this, list, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnClickListeners$lambda$6(HudCaptBinding hudCaptBinding, List list, View view) {
        HudCapt hudCapt = INSTANCE;
        boolean z = isOpenList;
        isOpenList = !z;
        if (!z) {
            hudCapt.closeListAfterFiveSecond(hudCaptBinding, list);
        }
        hudCapt.checkOpenList(hudCaptBinding, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkOpenList(HudCaptBinding hudCaptBinding, List<HudCaptItemModel> list) {
        Context context = hudCaptBinding.getRoot().getContext();
        if (isOpenList) {
            hudCaptBinding.tvBtnTitle.setText(context.getString(R.string.hide_list));
            hudCaptBinding.ivArrow.setScaleY(-1.0f);
            adapter.submitList(list);
            return;
        }
        hudCaptBinding.tvBtnTitle.setText(context.getString(R.string.all_list));
        hudCaptBinding.ivArrow.setScaleY(1.0f);
        adapter.submitList(CollectionsKt.listOf(CollectionsKt.first((List<? extends Object>) list)));
    }

    private final void startTimer(long j, HudCaptBinding hudCaptBinding) {
        Job launch$default;
        Job job = timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new HudCapt$startTimer$1(j, hudCaptBinding, null), 3, null);
        timerJob = launch$default;
        if (launch$default != null) {
            launch$default.start();
        }
    }

    private final void closeListAfterFiveSecond(HudCaptBinding hudCaptBinding, List<HudCaptItemModel> list) {
        Job launch$default;
        Job job = closeListJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new HudCapt$closeListAfterFiveSecond$1(hudCaptBinding, list, null), 3, null);
        closeListJob = launch$default;
        if (launch$default != null) {
            launch$default.start();
        }
    }
}
