package com.arizonagames.feature.arizona.family.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.family.R;
import com.arizonagames.feature.arizona.family.data.CapturesItem;
import com.arizonagames.feature.arizona.family.data.FamilyWarData;
import com.arizonagames.feature.arizona.family.data.GangZonesTopItem;
import com.arizonagames.feature.arizona.family.databinding.FamilyWarItemBinding;
import com.google.android.material.timepicker.TimeModel;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
/* compiled from: WarsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\nJ\u0014\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010!\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/arizonagames/feature/arizona/family/adapters/WarsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/family/adapters/WarItemViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "data", "Lcom/arizonagames/feature/arizona/family/data/FamilyWarData;", "top", "", "Lcom/arizonagames/feature/arizona/family/data/GangZonesTopItem;", "meetings", "Lcom/arizonagames/feature/arizona/family/data/CapturesItem;", "items", "", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setInfo", "info", "setTop", "setMeetings", "family"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WarsAdapter extends RecyclerView.Adapter<WarItemViewHolder> {
    private FamilyWarData data;
    private List<Integer> items;
    private List<CapturesItem> meetings;
    private final Function1<Integer, Unit> onClick;
    private List<GangZonesTopItem> top;

    /* JADX WARN: Multi-variable type inference failed */
    public WarsAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.data = new FamilyWarData(CollectionsKt.emptyList(), 0, 0);
        this.top = CollectionsKt.emptyList();
        this.meetings = CollectionsKt.emptyList();
        this.items = CollectionsKt.toMutableList(new IntRange(0, 9));
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
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_war_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new WarItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(WarItemViewHolder holder, int i) {
        int i2;
        String string;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = (Integer) CollectionsKt.getOrNull(this.items, i);
        if (num != null) {
            final int intValue = num.intValue();
            FamilyWarItemBinding binding = holder.getBinding();
            Context context = binding.getRoot().getContext();
            String str = "???";
            if (intValue <= 3) {
                if (intValue == 3) {
                    binding.getRoot().setVisibility(8);
                } else {
                    binding.getRoot().setVisibility(0);
                }
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
                } else {
                    i3 = R.drawable.family_menu_ic_info;
                }
                if (intValue == 0) {
                    i4 = R.drawable.family_war_ic_bg1;
                } else if (intValue == 1) {
                    i4 = R.drawable.family_war_ic_bg2;
                } else if (intValue == 2) {
                    i4 = R.drawable.family_war_ic_bg3;
                } else {
                    i4 = R.drawable.family_estate_ic_adi_kit;
                }
                if (intValue == 0) {
                    str = context.getString(R.string.family_war_my_captures);
                } else if (intValue == 1) {
                    str = context.getString(R.string.family_war_top_families);
                } else if (intValue == 2) {
                    str = context.getString(R.string.family_info);
                }
                Intrinsics.checkNotNull(str);
                binding.container0.setVisibility(8);
                binding.container1.setVisibility(8);
                binding.container2.setVisibility(8);
                if (intValue == 0) {
                    binding.container0.setVisibility(0);
                } else if (intValue == 1) {
                    binding.container1.setVisibility(0);
                } else if (intValue == 2) {
                    binding.container2.setVisibility(0);
                }
                binding.atk1.setVisibility(4);
                binding.atk2.setVisibility(4);
                binding.atk3.setVisibility(4);
                CapturesItem capturesItem = (CapturesItem) CollectionsKt.getOrNull(this.meetings, 0);
                if (capturesItem != null) {
                    binding.atk1.setVisibility(0);
                    binding.attack1.setText(capturesItem.getAttack_family_name());
                    binding.deffence1.setText(capturesItem.getFamily_name());
                    TextView textView2 = binding.timeText1;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(capturesItem.getAttack_hour())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(capturesItem.getAttack_minute())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    textView2.setText(format + StringUtils.PROCESS_POSTFIX_DELIMITER + format2);
                    binding.terCard1.setVisibility(8);
                    int capture_id_zone = capturesItem.getCapture_id_zone();
                    binding.terCard1.setVisibility(0);
                    binding.terText1.setText(String.valueOf(capture_id_zone));
                }
                CapturesItem capturesItem2 = (CapturesItem) CollectionsKt.getOrNull(this.meetings, 1);
                if (capturesItem2 != null) {
                    binding.atk2.setVisibility(0);
                    binding.attack2.setText(capturesItem2.getAttack_family_name());
                    binding.deffence2.setText(capturesItem2.getFamily_name());
                    TextView textView3 = binding.timeText2;
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String format3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(capturesItem2.getAttack_hour())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                    String format4 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(capturesItem2.getAttack_minute())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                    textView3.setText(format3 + StringUtils.PROCESS_POSTFIX_DELIMITER + format4);
                    binding.terCard2.setVisibility(8);
                    int capture_id_zone2 = capturesItem2.getCapture_id_zone();
                    binding.terCard2.setVisibility(0);
                    binding.terText2.setText(String.valueOf(capture_id_zone2));
                }
                CapturesItem capturesItem3 = (CapturesItem) CollectionsKt.getOrNull(this.meetings, 2);
                if (capturesItem3 != null) {
                    binding.atk2.setVisibility(0);
                    binding.attack2.setText(capturesItem3.getAttack_family_name());
                    binding.deffence3.setText(capturesItem3.getFamily_name());
                    TextView textView4 = binding.timeText3;
                    StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                    String format5 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(capturesItem3.getAttack_hour())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                    StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                    String format6 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(capturesItem3.getAttack_minute())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
                    textView4.setText(format5 + StringUtils.PROCESS_POSTFIX_DELIMITER + format6);
                    binding.terCard3.setVisibility(8);
                    int capture_id_zone3 = capturesItem3.getCapture_id_zone();
                    i5 = 0;
                    binding.terCard3.setVisibility(0);
                    binding.terText3.setText(String.valueOf(capture_id_zone3));
                } else {
                    i5 = 0;
                }
                GangZonesTopItem gangZonesTopItem = (GangZonesTopItem) CollectionsKt.getOrNull(this.top, i5);
                if (gangZonesTopItem != null) {
                    binding.info1.setText(gangZonesTopItem.getFamily_name());
                    binding.info11.setText(context.getString(R.string.family_territories_count_value, Integer.valueOf(gangZonesTopItem.getTerritory_count())));
                }
                GangZonesTopItem gangZonesTopItem2 = (GangZonesTopItem) CollectionsKt.getOrNull(this.top, 1);
                if (gangZonesTopItem2 != null) {
                    binding.info2.setText(gangZonesTopItem2.getFamily_name());
                    binding.info22.setText(context.getString(R.string.family_territories_count_value, Integer.valueOf(gangZonesTopItem2.getTerritory_count())));
                }
                GangZonesTopItem gangZonesTopItem3 = (GangZonesTopItem) CollectionsKt.getOrNull(this.top, 2);
                if (gangZonesTopItem3 != null) {
                    binding.info3.setText(gangZonesTopItem3.getFamily_name());
                    binding.info33.setText(context.getString(R.string.family_territories_count_value, Integer.valueOf(gangZonesTopItem3.getTerritory_count())));
                }
                binding.rank.setText(context.getString(R.string.family_rank_plus_value, Integer.valueOf(this.data.getRank())));
                binding.terr.setText(context.getString(R.string.family_territories_short_value, Integer.valueOf(this.data.getTerritories())));
                binding.level2Image.setImageResource(i3);
                binding.level2ImageBg.setImageResource(i4);
                binding.item2Title.setText(str);
            } else {
                binding.card2.setVisibility(8);
                binding.card1.setVisibility(0);
                switch (intValue) {
                    case 4:
                        i2 = R.drawable.family_war_ic_map;
                        break;
                    case 5:
                        i2 = R.drawable.family_menu_ic_info;
                        break;
                    case 6:
                        i2 = R.drawable.family_war_ic_arms;
                        break;
                    case 7:
                        i2 = R.drawable.family_war_ic_map;
                        break;
                    case 8:
                        i2 = R.drawable.family_war_ic_business;
                        break;
                    case 9:
                        i2 = R.drawable.family_war_ic_rank;
                        break;
                    default:
                        i2 = R.drawable.family_menu_ic_info;
                        break;
                }
                switch (intValue) {
                    case 4:
                        string = context.getString(R.string.family_war_map_title);
                        break;
                    case 5:
                        string = context.getString(R.string.family_war_useful_info_title);
                        break;
                    case 6:
                        string = context.getString(R.string.family_war_meetings_title);
                        break;
                    case 7:
                        string = context.getString(R.string.family_war_territories_title);
                        break;
                    case 8:
                        string = context.getString(R.string.family_war_enterprise_title);
                        break;
                    case 9:
                        string = context.getString(R.string.family_battle_access);
                        break;
                    default:
                        string = "???";
                        break;
                }
                Intrinsics.checkNotNull(string);
                switch (intValue) {
                    case 4:
                        str = context.getString(R.string.family_war_map_desc);
                        break;
                    case 5:
                        str = context.getString(R.string.family_war_useful_info_desc);
                        break;
                    case 6:
                        str = context.getString(R.string.family_war_meetings_desc);
                        break;
                    case 7:
                        str = context.getString(R.string.family_war_territories_desc);
                        break;
                    case 8:
                        str = context.getString(R.string.family_war_enterprise_desc);
                        break;
                    case 9:
                        str = context.getString(R.string.family_war_access_desc);
                        break;
                }
                Intrinsics.checkNotNull(str);
                binding.getRoot().setAlpha(this.data.getDisabledItems().contains(Integer.valueOf(intValue + (-4))) ? 0.2f : 1.0f);
                binding.levelImage.setImageResource(i2);
                binding.itemTitle.setText(string);
                binding.itemDesc.setText(str);
                binding.card1.setCardBackgroundColor(Color.parseColor("#0DFFFFFF"));
            }
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.family.adapters.WarsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WarsAdapter.onBindViewHolder$lambda$0$6(WarsAdapter.this, intValue, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$6(WarsAdapter warsAdapter, int i, View view) {
        warsAdapter.onClick.invoke(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void setInfo(FamilyWarData info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.data = info;
        notifyDataSetChanged();
    }

    public final void setTop(List<GangZonesTopItem> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.top = info;
        notifyDataSetChanged();
    }

    public final void setMeetings(List<CapturesItem> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.meetings = info;
        notifyDataSetChanged();
    }
}
