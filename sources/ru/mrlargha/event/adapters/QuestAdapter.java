package ru.mrlargha.event.adapters;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
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
import ru.mrlargha.event.data.QuestData;
import ru.mrlargha.feature.event.R;
import ru.mrlargha.feature.event.databinding.EventTaskItemBinding;
/* compiled from: QuestAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\b2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0014\u0010\u0018\u001a\u00020\b2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u0000H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0014\u0010\u001a\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\u0006\u0010\u001d\u001a\u00020\bJ\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lru/mrlargha/event/adapters/QuestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/event/adapters/QuestAdapter$PiratesTaskViewHolder;", "completeColor", "", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/event/data/QuestData;", "", "onClickPrise", "Lkotlin/Function2;", "", "Landroid/view/View;", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "itemsList", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onViewRecycled", "getItemCount", "addAllItems", "items", "", "clearList", "formatSeconds", "seconds", "context", "Landroid/content/Context;", "PiratesTaskViewHolder", NotificationCompat.CATEGORY_EVENT}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QuestAdapter extends RecyclerView.Adapter<PiratesTaskViewHolder> {
    private final int completeColor;
    private final List<QuestData> itemsList;
    private final Function1<QuestData, Unit> onClick;
    private final Function2<String, View, Unit> onClickPrise;

    /* JADX WARN: Multi-variable type inference failed */
    public QuestAdapter(int i, Function1<? super QuestData, Unit> onClick, Function2<? super String, ? super View, Unit> onClickPrise) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onClickPrise, "onClickPrise");
        this.completeColor = i;
        this.onClick = onClick;
        this.onClickPrise = onClickPrise;
        this.itemsList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PiratesTaskViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_task_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new PiratesTaskViewHolder(this, inflate, this.onClickPrise);
    }

    /* JADX WARN: Type inference failed for: r1v22, types: [ru.mrlargha.event.adapters.QuestAdapter$onBindViewHolder$1$6$1] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PiratesTaskViewHolder holder, int i) {
        final QuestAdapter questAdapter;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final QuestData questData = (QuestData) CollectionsKt.getOrNull(this.itemsList, i);
        if (questData == null) {
            return;
        }
        final Context context = holder.itemView.getContext();
        CountDownTimer timer = holder.getTimer();
        if (timer != null) {
            timer.cancel();
        }
        final EventTaskItemBinding binding = holder.getBinding();
        String image = questData.getImage();
        if (StringsKt.isBlank(image)) {
            image = null;
        }
        if (image != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new QuestAdapter$onBindViewHolder$1$2$1(image, binding, null), 3, null);
        }
        binding.tvName.setText(questData.getName());
        binding.tvDescription.setText(questData.getDescription());
        binding.tvTaskCount.setText(questData.getProgress().getCurrent() + "/" + questData.getProgress().getMax());
        binding.progressBar.setMax(questData.getProgress().getMax());
        binding.progressBar.setProgress(questData.getProgress().getCurrent());
        binding.tvCompletePercent.setText((questData.getProgress().getMax() > 0 ? (questData.getProgress().getCurrent() * 100) / questData.getProgress().getMax() : 0) + "%");
        binding.rvTaskPrise.setAdapter(holder.getAdapter());
        holder.getAdapter().setPriseList(questData.getItems());
        binding.ivCheckMark.setVisibility(8);
        binding.completeTextContainer.setVisibility(8);
        binding.tvCompletePercent.setVisibility(0);
        binding.errorOverlay.setVisibility(8);
        binding.btnGet.setVisibility(0);
        binding.progressBarContainer.setVisibility(0);
        binding.tvTaskCount.setTextColor(-1);
        binding.typeStory.setVisibility(8);
        binding.typeEveryday.setVisibility(8);
        binding.typeNewyear.setVisibility(8);
        String type = questData.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != 109770997) {
                if (hashCode != 281966241) {
                    if (hashCode == 1846305245 && type.equals("newyear")) {
                        binding.typeNewyear.setVisibility(0);
                    }
                } else if (type.equals("everyday")) {
                    binding.typeEveryday.setVisibility(0);
                }
            } else if (type.equals("story")) {
                binding.typeStory.setVisibility(0);
            }
        }
        String buttonType = questData.getButtonType();
        int hashCode2 = buttonType.hashCode();
        if (hashCode2 == -1423461112) {
            if (buttonType.equals("accept")) {
                binding.btnGet.setBackgroundResource(R.drawable.event_task_btn_bg_white);
                binding.tvBtnGet.setText(context.getString(R.string.event_task_accept));
            }
            binding.btnGet.setBackgroundResource(R.drawable.event_task_btn_bg_gold);
            binding.tvBtnGet.setText(context.getString(R.string.event_get_reward));
        } else if (hashCode2 == 3089282) {
            if (buttonType.equals("done")) {
                binding.ivCheckMark.setVisibility(0);
                binding.btnGet.setBackgroundResource(R.drawable.event_task_btn_bg_white_transparent);
                binding.tvBtnGet.setText(context.getString(R.string.event_received));
            }
            binding.btnGet.setBackgroundResource(R.drawable.event_task_btn_bg_gold);
            binding.tvBtnGet.setText(context.getString(R.string.event_get_reward));
        } else {
            if (hashCode2 == 3198785 && buttonType.equals("help")) {
                binding.btnGet.setBackgroundResource(R.drawable.event_task_btn_bg_white);
                binding.tvBtnGet.setText(context.getString(R.string.event_task_track));
            }
            binding.btnGet.setBackgroundResource(R.drawable.event_task_btn_bg_gold);
            binding.tvBtnGet.setText(context.getString(R.string.event_get_reward));
        }
        if (questData.getProgress().getCurrent() == questData.getProgress().getMax()) {
            binding.completeTextContainer.setVisibility(0);
            binding.tvCompletePercent.setVisibility(8);
            binding.tvTaskCount.setTextColor(this.completeColor);
            if (!Intrinsics.areEqual(questData.getButtonType(), "done")) {
                binding.btnGet.setBackgroundResource(R.drawable.event_task_btn_bg_gold);
                binding.tvBtnGet.setText(context.getString(R.string.event_get_reward));
            }
        }
        String error = questData.getError();
        if (error != null) {
            if (StringsKt.isBlank(error)) {
                error = null;
            }
            if (error != null) {
                binding.errorOverlay.setVisibility(0);
                binding.tvErrorText.setText(error);
                binding.btnGet.setVisibility(4);
                binding.progressBarContainer.setVisibility(4);
            }
        }
        String timer2 = questData.getTimer();
        if (timer2 != null && (intOrNull = StringsKt.toIntOrNull(timer2)) != null) {
            Integer num = intOrNull.intValue() > 0 ? intOrNull : null;
            if (num != null) {
                int intValue = num.intValue();
                binding.errorOverlay.setVisibility(0);
                TextView textView = binding.tvErrorText;
                int i2 = R.string.event_available_in;
                Intrinsics.checkNotNull(context);
                textView.setText(context.getString(i2, formatSeconds(intValue, context)));
                binding.btnGet.setVisibility(4);
                binding.progressBarContainer.setVisibility(4);
                final long j = intValue * 1000;
                questAdapter = this;
                ?? r1 = new CountDownTimer(j) { // from class: ru.mrlargha.event.adapters.QuestAdapter$onBindViewHolder$1$6$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long j2) {
                        String formatSeconds;
                        TextView textView2 = EventTaskItemBinding.this.tvErrorText;
                        Context context2 = context;
                        int i3 = R.string.event_available_in;
                        QuestAdapter questAdapter2 = questAdapter;
                        Context context3 = context;
                        Intrinsics.checkNotNull(context3);
                        formatSeconds = questAdapter2.formatSeconds((int) (j2 / 1000), context3);
                        textView2.setText(context2.getString(i3, formatSeconds));
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        EventTaskItemBinding.this.errorOverlay.setVisibility(8);
                    }
                };
                r1.start();
                holder.setTimer((CountDownTimer) r1);
                binding.btnGet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.adapters.QuestAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuestAdapter.onBindViewHolder$lambda$0$6(QuestAdapter.this, questData, view);
                    }
                });
            }
        }
        questAdapter = this;
        binding.btnGet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.adapters.QuestAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestAdapter.onBindViewHolder$lambda$0$6(QuestAdapter.this, questData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$6(QuestAdapter questAdapter, QuestData questData, View view) {
        questAdapter.onClick.invoke(questData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(PiratesTaskViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CountDownTimer timer = holder.getTimer();
        if (timer != null) {
            timer.cancel();
        }
        holder.setTimer(null);
        super.onViewRecycled((QuestAdapter) holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<QuestData> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.itemsList.clear();
        this.itemsList.addAll(items);
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatSeconds(int i, Context context) {
        int i2 = i / 86400;
        int i3 = (i % 86400) / DateCalculationsKt.SECONDS_PER_HOUR;
        int i4 = (i % DateCalculationsKt.SECONDS_PER_HOUR) / 60;
        int i5 = i % 60;
        ArrayList arrayList = new ArrayList();
        if (i2 > 0) {
            String string = context.getString(R.string.event_time_day_short, Integer.valueOf(i2));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList.add(string);
        }
        if (i3 > 0) {
            String string2 = context.getString(R.string.event_time_hour_short, Integer.valueOf(i3));
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            arrayList.add(string2);
        }
        if (i4 > 0) {
            String string3 = context.getString(R.string.event_time_minute_short, Integer.valueOf(i4));
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            arrayList.add(string3);
        }
        if (i2 == 0 && i5 > 0) {
            String string4 = context.getString(R.string.event_time_second_short, Integer.valueOf(i5));
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            arrayList.add(string4);
        }
        if (arrayList.isEmpty()) {
            String string5 = context.getString(R.string.event_time_zero);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            arrayList.add(string5);
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    /* compiled from: QuestAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lru/mrlargha/event/adapters/QuestAdapter$PiratesTaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onClick", "Lkotlin/Function2;", "", "", "<init>", "(Lru/mrlargha/event/adapters/QuestAdapter;Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", "binding", "Lru/mrlargha/feature/event/databinding/EventTaskItemBinding;", "getBinding", "()Lru/mrlargha/feature/event/databinding/EventTaskItemBinding;", "adapter", "Lru/mrlargha/event/adapters/PriseAdapter;", "getAdapter", "()Lru/mrlargha/event/adapters/PriseAdapter;", NotificationCompat.CATEGORY_EVENT}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class PiratesTaskViewHolder extends RecyclerView.ViewHolder {
        private final PriseAdapter adapter;
        private final EventTaskItemBinding binding;
        final /* synthetic */ QuestAdapter this$0;
        private CountDownTimer timer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PiratesTaskViewHolder(QuestAdapter questAdapter, View view, Function2<? super String, ? super View, Unit> onClick) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.this$0 = questAdapter;
            EventTaskItemBinding bind = EventTaskItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
            this.adapter = new PriseAdapter(onClick);
        }

        public final CountDownTimer getTimer() {
            return this.timer;
        }

        public final void setTimer(CountDownTimer countDownTimer) {
            this.timer = countDownTimer;
        }

        public final EventTaskItemBinding getBinding() {
            return this.binding;
        }

        public final PriseAdapter getAdapter() {
            return this.adapter;
        }
    }
}
