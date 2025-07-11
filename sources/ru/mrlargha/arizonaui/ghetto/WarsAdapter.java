package ru.mrlargha.arizonaui.ghetto;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.GhettoWarItemBinding;
import ru.mrlargha.arizonaui.ghetto.data.BandInfo;
import ru.mrlargha.arizonaui.ghetto.data.CaptureData;
import ru.mrlargha.arizonaui.ghetto.data.RatingData;
/* compiled from: WarsAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nJ\u0014\u0010#\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010$\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\fJ\u000e\u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/WarsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/ghetto/WarItemViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "data", "Lru/mrlargha/arizonaui/ghetto/data/BandInfo;", "top", "", "Lru/mrlargha/arizonaui/ghetto/data/RatingData;", "meetings", "Lru/mrlargha/arizonaui/ghetto/data/CaptureData;", "meetingsOwns", FirebaseAnalytics.Param.ITEMS, "", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "estateColor", "descColor", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setInfo", "info", "setTop", "setMeetings", "setInfoCount", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WarsAdapter extends RecyclerView.Adapter<WarItemViewHolder> {
    private BandInfo data;
    private final int descColor;
    private final int estateColor;
    private List<Integer> items;
    private List<CaptureData> meetings;
    private List<CaptureData> meetingsOwns;
    private final Function1<Integer, Unit> onClick;
    private List<RatingData> top;

    /* JADX WARN: Multi-variable type inference failed */
    public WarsAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.data = new BandInfo(0, 0, 0, 0);
        this.top = CollectionsKt.emptyList();
        this.meetings = CollectionsKt.emptyList();
        this.meetingsOwns = CollectionsKt.emptyList();
        this.items = CollectionsKt.toMutableList(new IntRange(0, 4));
        this.estateColor = Color.parseColor("#E0CA4C");
        this.descColor = Color.parseColor("#ABABAB");
    }

    public final List<Integer> getItems() {
        return this.items;
    }

    public final void setItems(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WarItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ghetto_war_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new WarItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(WarItemViewHolder holder, int i) {
        int i2;
        String str;
        int i3;
        int i4;
        Pair formatUnixTime;
        Pair formatUnixTime2;
        Pair formatUnixTime3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = (Integer) CollectionsKt.getOrNull(this.items, i);
        if (num != null) {
            final int intValue = num.intValue();
            GhettoWarItemBinding binding = holder.getBinding();
            String str2 = "???";
            if (intValue <= 3) {
                TextView textView = binding.titleHint;
                if (intValue == 1) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                binding.card1.setVisibility(8);
                binding.card2.setVisibility(0);
                if (intValue == 0) {
                    i3 = R.drawable.family_war_ic_1;
                } else if (intValue == 1) {
                    i3 = R.drawable.family_war_ic_2;
                } else if (intValue == 2) {
                    i3 = R.drawable.family_war_ic_3;
                } else if (intValue == 3) {
                    i3 = R.drawable.family_war_ic_1;
                } else {
                    i3 = R.drawable.family_menu_ic_info;
                }
                if (intValue == 0) {
                    i4 = R.drawable.family_war_ic_bg1;
                } else if (intValue == 1) {
                    i4 = R.drawable.family_war_ic_bg2;
                } else if (intValue == 2) {
                    i4 = R.drawable.family_war_ic_bg3;
                } else if (intValue == 3) {
                    i4 = R.drawable.family_war_ic_bg1;
                } else {
                    i4 = R.drawable.family_estate_ic_adi_kit;
                }
                if (intValue == 0) {
                    str2 = "Предстоящие капты";
                } else if (intValue == 1) {
                    str2 = "ТОП Банды ";
                } else if (intValue == 2) {
                    str2 = "Информация";
                } else if (intValue == 3) {
                    str2 = "Капты моей банды";
                }
                binding.container0.setVisibility(8);
                binding.container1.setVisibility(8);
                binding.container2.setVisibility(8);
                binding.emptyList.setVisibility(8);
                if (intValue == 0) {
                    binding.container0.setVisibility(0);
                    if (this.meetings.isEmpty()) {
                        binding.emptyList.setVisibility(0);
                    }
                } else if (intValue == 1) {
                    binding.container1.setVisibility(0);
                } else if (intValue == 2) {
                    binding.container2.setVisibility(0);
                } else if (intValue == 3) {
                    binding.container0.setVisibility(0);
                    if (this.meetings.isEmpty()) {
                        binding.emptyList.setVisibility(0);
                    }
                }
                binding.atk1.setVisibility(4);
                binding.atk2.setVisibility(4);
                binding.atk3.setVisibility(4);
                List<CaptureData> list = intValue == 0 ? this.meetings : this.meetingsOwns;
                CaptureData captureData = (CaptureData) CollectionsKt.getOrNull(list, 0);
                if (captureData != null) {
                    binding.atk1.setVisibility(0);
                    binding.attack1.setText(ColorsKt.ghettoNames(captureData.getAttack_fraction_id()));
                    binding.deffence1.setText(ColorsKt.ghettoNames(captureData.getDefend_fraction_id()));
                    TextView textView2 = binding.timeText1;
                    formatUnixTime3 = WarsAdapterKt.formatUnixTime(captureData.getDate_unix());
                    textView2.setText((CharSequence) formatUnixTime3.getSecond());
                    binding.attack1.setTextColor(Color.parseColor(ColorsKt.ghettoColors(captureData.getAttack_fraction_id())));
                    binding.deffence1.setTextColor(Color.parseColor(ColorsKt.ghettoColors(captureData.getDefend_fraction_id())));
                }
                CaptureData captureData2 = (CaptureData) CollectionsKt.getOrNull(list, 1);
                if (captureData2 != null) {
                    binding.atk2.setVisibility(0);
                    binding.attack2.setTextColor(Color.parseColor(ColorsKt.ghettoColors(captureData2.getAttack_fraction_id())));
                    binding.deffence2.setTextColor(Color.parseColor(ColorsKt.ghettoColors(captureData2.getDefend_fraction_id())));
                    binding.attack2.setText(ColorsKt.ghettoNames(captureData2.getAttack_fraction_id()));
                    binding.deffence2.setText(ColorsKt.ghettoNames(captureData2.getDefend_fraction_id()));
                    TextView textView3 = binding.timeText2;
                    formatUnixTime2 = WarsAdapterKt.formatUnixTime(captureData2.getDate_unix());
                    textView3.setText((CharSequence) formatUnixTime2.getSecond());
                }
                CaptureData captureData3 = (CaptureData) CollectionsKt.getOrNull(list, 2);
                if (captureData3 != null) {
                    binding.atk3.setVisibility(0);
                    binding.attack3.setTextColor(Color.parseColor(ColorsKt.ghettoColors(captureData3.getAttack_fraction_id())));
                    binding.deffence3.setTextColor(Color.parseColor(ColorsKt.ghettoColors(captureData3.getDefend_fraction_id())));
                    binding.attack3.setText(ColorsKt.ghettoNames(captureData3.getAttack_fraction_id()));
                    binding.deffence3.setText(ColorsKt.ghettoNames(captureData3.getDefend_fraction_id()));
                    TextView textView4 = binding.timeText3;
                    formatUnixTime = WarsAdapterKt.formatUnixTime(captureData3.getDate_unix());
                    textView4.setText((CharSequence) formatUnixTime.getSecond());
                }
                RatingData ratingData = (RatingData) CollectionsKt.getOrNull(this.top, 0);
                if (ratingData != null) {
                    binding.info1.setText(ColorsKt.ghettoNames(ratingData.getFraction_id()));
                    binding.info1.setTextColor(Color.parseColor(ColorsKt.ghettoColors(ratingData.getFraction_id())));
                    binding.info11.setText(ratingData.getTerritories() + " территории");
                }
                RatingData ratingData2 = (RatingData) CollectionsKt.getOrNull(this.top, 1);
                if (ratingData2 != null) {
                    binding.info2.setText(ColorsKt.ghettoNames(ratingData2.getFraction_id()));
                    binding.info2.setTextColor(Color.parseColor(ColorsKt.ghettoColors(ratingData2.getFraction_id())));
                    binding.info22.setText(ratingData2.getTerritories() + " территории");
                }
                RatingData ratingData3 = (RatingData) CollectionsKt.getOrNull(this.top, 2);
                if (ratingData3 != null) {
                    binding.info3.setText(ColorsKt.ghettoNames(ratingData3.getFraction_id()));
                    binding.info3.setTextColor(Color.parseColor(ColorsKt.ghettoColors(ratingData3.getFraction_id())));
                    binding.info33.setText(ratingData3.getTerritories() + " территории");
                }
                binding.battles.setText(String.valueOf(this.data.getFights_count()));
                binding.terrs.setText(String.valueOf(this.data.getTerritories()));
                binding.level2Image.setImageResource(i3);
                binding.level2ImageBg.setImageResource(i4);
                binding.item2Title.setText(str2);
            } else {
                binding.card2.setVisibility(8);
                binding.card1.setVisibility(0);
                if (intValue == 4) {
                    i2 = R.drawable.family_war_ic_map;
                } else {
                    i2 = R.drawable.family_menu_ic_info;
                }
                if (intValue != 4) {
                    str = "???";
                } else {
                    str = "Карта территорий";
                }
                if (intValue == 4) {
                    str2 = "Карта территорий банд";
                }
                int parseColor = Color.parseColor("#0DFFFFFF");
                binding.levelImage.setImageResource(i2);
                binding.itemTitle.setText(str);
                binding.itemDesc.setText(str2);
                binding.card1.setCardBackgroundColor(parseColor);
            }
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.WarsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WarsAdapter.onBindViewHolder$lambda$7$lambda$6(WarsAdapter.this, intValue, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$7$lambda$6(WarsAdapter warsAdapter, int i, View view) {
        warsAdapter.onClick.invoke(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void setInfo(BandInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.data = info;
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.meetings) {
            CaptureData captureData = (CaptureData) obj;
            if (captureData.getAttack_fraction_id() == this.data.getId() || captureData.getDefend_fraction_id() == this.data.getId()) {
                arrayList.add(obj);
            }
        }
        this.meetingsOwns = arrayList;
        notifyDataSetChanged();
    }

    public final void setTop(List<RatingData> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.top = info;
        notifyDataSetChanged();
    }

    public final void setMeetings(List<CaptureData> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.meetings = info;
        ArrayList arrayList = new ArrayList();
        for (Object obj : info) {
            CaptureData captureData = (CaptureData) obj;
            if (captureData.getAttack_fraction_id() == this.data.getId() || captureData.getDefend_fraction_id() == this.data.getId()) {
                arrayList.add(obj);
            }
        }
        this.meetingsOwns = arrayList;
        notifyDataSetChanged();
    }

    public final void setInfoCount(int i) {
        this.data = BandInfo.copy$default(this.data, 0, 0, i, 0, 11, null);
        notifyDataSetChanged();
    }
}
