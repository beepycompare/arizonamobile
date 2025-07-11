package ru.mrlargha.arizonaui.biz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.biz.MyBusinessScreen;
import ru.mrlargha.arizonaui.databinding.MyBusinessParentStatItemBinding;
/* compiled from: MyBusinessParentStatAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0010R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessParentStatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/biz/MyBusinessParentStatAdapter$BusinessViewHolder;", "<init>", "()V", "businessItemStatList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessDetailInfo;", "Lkotlin/collections/ArrayList;", "onParentItemClickListener", "Lru/mrlargha/arizonaui/biz/MyBusinessParentStatAdapter$OnParentItemClickListener;", "counter", "", "hMap", "", "setOnParentItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addParentStat", "info", "clearStat", "OnParentItemClickListener", "BusinessViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessParentStatAdapter extends RecyclerView.Adapter<BusinessViewHolder> {
    private int counter;
    private OnParentItemClickListener onParentItemClickListener;
    private final ArrayList<MyBusinessScreen.Companion.BusinessDetailInfo> businessItemStatList = new ArrayList<>();
    private Map<Integer, Integer> hMap = new LinkedHashMap();

    /* compiled from: MyBusinessParentStatAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessParentStatAdapter$OnParentItemClickListener;", "", "callback", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnParentItemClickListener {
        void callback(int i);
    }

    public final void setOnParentItemClickListener(OnParentItemClickListener onParentItemClickListener) {
        Intrinsics.checkNotNullParameter(onParentItemClickListener, "onParentItemClickListener");
        this.onParentItemClickListener = onParentItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusinessViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_business_parent_stat_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BusinessViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusinessViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyBusinessScreen.Companion.BusinessDetailInfo businessDetailInfo = this.businessItemStatList.get(i);
        Intrinsics.checkNotNullExpressionValue(businessDetailInfo, "get(...)");
        MyBusinessScreen.Companion.BusinessDetailInfo businessDetailInfo2 = businessDetailInfo;
        MyBusinessParentStatItemBinding binding = holder.getBinding();
        binding.title.setText(businessDetailInfo2.getTitle());
        if (businessDetailInfo2.getEditable() == 0) {
            binding.editButton.setVisibility(8);
        } else {
            Map<Integer, Integer> map = this.hMap;
            Integer valueOf = Integer.valueOf(i);
            int i2 = this.counter;
            this.counter = i2 + 1;
            map.put(valueOf, Integer.valueOf(i2));
            binding.editButton.setVisibility(0);
        }
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        CardView editButton = binding.editButton;
        Intrinsics.checkNotNullExpressionValue(editButton, "editButton");
        EasyAnimation.animateClick$default(easyAnimation, editButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessParentStatAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$2$lambda$1;
                onBindViewHolder$lambda$2$lambda$1 = MyBusinessParentStatAdapter.onBindViewHolder$lambda$2$lambda$1(MyBusinessParentStatAdapter.this, i);
                return onBindViewHolder$lambda$2$lambda$1;
            }
        }, 3, null);
        MyBusinessChildStatAdapter myBusinessChildStatAdapter = new MyBusinessChildStatAdapter();
        binding.childStatRc.setAdapter(myBusinessChildStatAdapter);
        myBusinessChildStatAdapter.addChildStat(businessDetailInfo2.getItems());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$1(MyBusinessParentStatAdapter myBusinessParentStatAdapter, int i) {
        Integer num = myBusinessParentStatAdapter.hMap.get(Integer.valueOf(i));
        if (num != null) {
            int intValue = num.intValue();
            OnParentItemClickListener onParentItemClickListener = myBusinessParentStatAdapter.onParentItemClickListener;
            if (onParentItemClickListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onParentItemClickListener");
                onParentItemClickListener = null;
            }
            onParentItemClickListener.callback(intValue);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.businessItemStatList.size();
    }

    /* compiled from: MyBusinessParentStatAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessParentStatAdapter$BusinessViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyBusinessParentStatItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyBusinessParentStatItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BusinessViewHolder extends RecyclerView.ViewHolder {
        private final MyBusinessParentStatItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BusinessViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyBusinessParentStatItemBinding bind = MyBusinessParentStatItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyBusinessParentStatItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addParentStat(MyBusinessScreen.Companion.BusinessDetailInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.businessItemStatList.add(info);
        notifyDataSetChanged();
    }

    public final void clearStat() {
        this.counter = 0;
        this.hMap.clear();
        this.businessItemStatList.clear();
    }
}
