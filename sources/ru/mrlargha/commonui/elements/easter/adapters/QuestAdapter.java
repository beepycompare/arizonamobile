package ru.mrlargha.commonui.elements.easter.adapters;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.datetime.internal.DateCalculationsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.EasterBattlePassTaskItemBinding;
import ru.mrlargha.commonui.elements.easter.data.QuestData;
/* compiled from: QuestAdapter.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001$B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u001c\u0010\u001a\u001a\u00020\b2\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0014\u0010\u001e\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 J\u0006\u0010!\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/elements/easter/adapters/QuestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/easter/adapters/QuestAdapter$EasterTaskViewHolder;", "isArizona", "", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/easter/data/QuestData;", "", "onClickPrise", "Lkotlin/Function2;", "", "Landroid/view/View;", "<init>", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "()Z", "getOnClickPrise", "()Lkotlin/jvm/functions/Function2;", "itemsList", "", "completeColor", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", FirebaseAnalytics.Param.ITEMS, "", "clearList", "formatSeconds", "seconds", "EasterTaskViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestAdapter extends RecyclerView.Adapter<EasterTaskViewHolder> {
    private final int completeColor;
    private final boolean isArizona;
    private final List<QuestData> itemsList;
    private final Function1<QuestData, Unit> onClick;
    private final Function2<String, View, Unit> onClickPrise;

    public final boolean isArizona() {
        return this.isArizona;
    }

    public final Function2<String, View, Unit> getOnClickPrise() {
        return this.onClickPrise;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuestAdapter(boolean z, Function1<? super QuestData, Unit> onClick, Function2<? super String, ? super View, Unit> onClickPrise) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onClickPrise, "onClickPrise");
        this.isArizona = z;
        this.onClick = onClick;
        this.onClickPrise = onClickPrise;
        this.itemsList = new ArrayList();
        this.completeColor = Color.parseColor("#FFE419");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EasterTaskViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.easter_battle_pass_task_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new EasterTaskViewHolder(this, inflate, this.onClickPrise);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EasterTaskViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final QuestData questData = (QuestData) CollectionsKt.getOrNull(this.itemsList, i);
        if (questData == null) {
            questData = (QuestData) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        final EasterBattlePassTaskItemBinding binding = holder.getBinding();
        String image = questData.getImage();
        if (image != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new QuestAdapter$onBindViewHolder$1$1$1(binding, image, null), 3, null);
        }
        binding.tvName.setText(questData.getName());
        binding.tvDescription.setText(questData.getDescription());
        binding.tvTaskCount.setText(questData.getProgress().getCurrent() + RemoteSettings.FORWARD_SLASH_STRING + questData.getProgress().getMax());
        binding.progressBar.setMax(questData.getProgress().getMax());
        binding.progressBar.setProgress(questData.getProgress().getCurrent());
        binding.rvTaskPrise.setAdapter(holder.getAdapter());
        holder.getAdapter().setPriseList(questData.getItems());
        binding.ivCheckMark.setVisibility(8);
        String buttonType = questData.getButtonType();
        int hashCode = buttonType.hashCode();
        if (hashCode == -1423461112) {
            if (buttonType.equals("accept")) {
                binding.btnGet.setBackgroundResource(R.drawable.easter_battle_pass_task_btn_bg_white);
                binding.tvBtnGet.setText("Принять задание");
            }
            binding.btnGet.setBackgroundResource(R.drawable.easter_battle_pass_task_btn_bg_gold);
            binding.tvBtnGet.setText("???");
            binding.ivCheckMark.setVisibility(0);
        } else if (hashCode == 3089282) {
            if (buttonType.equals("done")) {
                binding.ivCheckMark.setVisibility(0);
                binding.btnGet.setBackgroundResource(R.drawable.easter_battle_pass_task_btn_bg_white_transparent);
                binding.tvBtnGet.setText("Получено");
            }
            binding.btnGet.setBackgroundResource(R.drawable.easter_battle_pass_task_btn_bg_gold);
            binding.tvBtnGet.setText("???");
            binding.ivCheckMark.setVisibility(0);
        } else {
            if (hashCode == 3198785 && buttonType.equals("help")) {
                binding.btnGet.setBackgroundResource(R.drawable.easter_battle_pass_task_btn_bg_white);
                binding.tvBtnGet.setText("Отслеживать");
            }
            binding.btnGet.setBackgroundResource(R.drawable.easter_battle_pass_task_btn_bg_gold);
            binding.tvBtnGet.setText("???");
            binding.ivCheckMark.setVisibility(0);
        }
        binding.typeStory.setVisibility(8);
        binding.typeEveryday.setVisibility(8);
        String type = questData.getType();
        if (Intrinsics.areEqual(type, "everyday")) {
            binding.typeEveryday.setVisibility(0);
        } else if (Intrinsics.areEqual(type, "story")) {
            binding.typeStory.setVisibility(0);
        }
        if (questData.getProgress().getCurrent() == questData.getProgress().getMax()) {
            binding.completeTextContainer.setVisibility(0);
            binding.tvCompletePercent.setVisibility(8);
            binding.tvTaskCount.setTextColor(this.completeColor);
            binding.progressBar.setBackgroundColor(this.completeColor);
            binding.btnGet.setBackgroundResource(R.drawable.easter_battle_pass_task_btn_bg_gold);
            binding.tvBtnGet.setText("Получить награду");
        } else {
            binding.completeTextContainer.setVisibility(8);
            binding.tvCompletePercent.setText(((questData.getProgress().getCurrent() * 100) / questData.getProgress().getMax()) + "%");
            binding.tvCompletePercent.setVisibility(0);
            binding.tvTaskCount.setTextColor(-1);
            binding.progressBar.setBackgroundColor(-1);
        }
        if (Intrinsics.areEqual(questData.getButtonType(), "done")) {
            binding.ivCheckMark.setVisibility(0);
            binding.btnGet.setBackgroundResource(R.drawable.easter_battle_pass_task_btn_bg_white_transparent);
            binding.tvBtnGet.setText("Получено");
        }
        binding.errorOverlay.setVisibility(8);
        binding.btnGet.setVisibility(0);
        binding.progressBarContainer.setVisibility(0);
        if (questData.getError() != null) {
            binding.errorOverlay.setVisibility(0);
            binding.tvErrorText.setText(questData.getError());
            binding.btnGet.setVisibility(4);
            binding.progressBarContainer.setVisibility(4);
        }
        String timer = questData.getTimer();
        if (timer != null) {
            Integer intOrNull = StringsKt.toIntOrNull(timer);
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            if (intValue > 0) {
                binding.errorOverlay.setVisibility(0);
                binding.tvErrorText.setText("Будет доступно через\n" + formatSeconds(intValue));
                binding.btnGet.setVisibility(4);
                binding.progressBarContainer.setVisibility(4);
                CountDownTimer timer2 = holder.getTimer();
                if (timer2 != null) {
                    timer2.cancel();
                }
                final long j = intValue * 1000;
                holder.setTimer(new CountDownTimer(j) { // from class: ru.mrlargha.commonui.elements.easter.adapters.QuestAdapter$onBindViewHolder$1$3$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long j2) {
                        EasterBattlePassTaskItemBinding.this.tvErrorText.setText("Будет доступно через\n" + this.formatSeconds((int) (j2 / 1000)));
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        EasterBattlePassTaskItemBinding.this.errorOverlay.setVisibility(8);
                    }
                });
                CountDownTimer timer3 = holder.getTimer();
                if (timer3 != null) {
                    timer3.start();
                }
            }
        }
        binding.btnGet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.adapters.QuestAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestAdapter.onBindViewHolder$lambda$4$lambda$3(QuestAdapter.this, questData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4$lambda$3(QuestAdapter questAdapter, QuestData questData, View view) {
        questAdapter.onClick.invoke(questData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<QuestData> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new QuestAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }

    public final String formatSeconds(int i) {
        int i2 = i / 86400;
        int i3 = (i % 86400) / DateCalculationsKt.SECONDS_PER_HOUR;
        int i4 = (i % DateCalculationsKt.SECONDS_PER_HOUR) / 60;
        int i5 = i % 60;
        ArrayList arrayList = new ArrayList();
        if (i2 > 0) {
            arrayList.add(i2 + "д");
        }
        if (i3 > 0) {
            arrayList.add(i3 + "ч");
        }
        if (i4 > 0) {
            arrayList.add(i4 + "м");
        }
        if (i2 == 0 && i5 > 0) {
            arrayList.add(i5 + "с");
        }
        if (arrayList.isEmpty()) {
            arrayList.add("0с");
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    /* compiled from: QuestAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/easter/adapters/QuestAdapter$EasterTaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onClick", "Lkotlin/Function2;", "", "", "<init>", "(Lru/mrlargha/commonui/elements/easter/adapters/QuestAdapter;Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", "binding", "Lru/mrlargha/commonui/databinding/EasterBattlePassTaskItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/EasterBattlePassTaskItemBinding;", "adapter", "Lru/mrlargha/commonui/elements/easter/adapters/PriseAdapter;", "getAdapter", "()Lru/mrlargha/commonui/elements/easter/adapters/PriseAdapter;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class EasterTaskViewHolder extends RecyclerView.ViewHolder {
        private final PriseAdapter adapter;
        private final EasterBattlePassTaskItemBinding binding;
        final /* synthetic */ QuestAdapter this$0;
        private CountDownTimer timer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EasterTaskViewHolder(QuestAdapter questAdapter, View view, Function2<? super String, ? super View, Unit> onClick) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.this$0 = questAdapter;
            EasterBattlePassTaskItemBinding bind = EasterBattlePassTaskItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
            this.adapter = new PriseAdapter(questAdapter.isArizona(), onClick);
        }

        public final CountDownTimer getTimer() {
            return this.timer;
        }

        public final void setTimer(CountDownTimer countDownTimer) {
            this.timer = countDownTimer;
        }

        public final EasterBattlePassTaskItemBinding getBinding() {
            return this.binding;
        }

        public final PriseAdapter getAdapter() {
            return this.adapter;
        }
    }
}
