package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneChatMenuItemBinding;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MenuChatItem;
/* compiled from: MobilePhoneMessengerChatMenuAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0014\u0010\u0017\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0006R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerChatMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerChatMenuViewHolder;", "onClickMenu", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MenuChatItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnClickMenu", "()Lkotlin/jvm/functions/Function1;", "menuItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addMenuItems", "", "changeMenuItem", "menuItem", "clearMenuItems", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneMessengerChatMenuAdapter extends RecyclerView.Adapter<MobilePhoneMessengerChatMenuViewHolder> {
    private final ArrayList<MenuChatItem> menuItems;
    private final Function1<MenuChatItem, Unit> onClickMenu;

    public MobilePhoneMessengerChatMenuAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ MobilePhoneMessengerChatMenuAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerChatMenuAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = MobilePhoneMessengerChatMenuAdapter._init_$lambda$0((MenuChatItem) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(MenuChatItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<MenuChatItem, Unit> getOnClickMenu() {
        return this.onClickMenu;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MobilePhoneMessengerChatMenuAdapter(Function1<? super MenuChatItem, Unit> onClickMenu) {
        Intrinsics.checkNotNullParameter(onClickMenu, "onClickMenu");
        this.onClickMenu = onClickMenu;
        this.menuItems = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneMessengerChatMenuViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_phone_chat_menu_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MobilePhoneMessengerChatMenuViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MobilePhoneMessengerChatMenuViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MenuChatItem menuChatItem = this.menuItems.get(i);
        Intrinsics.checkNotNullExpressionValue(menuChatItem, "get(...)");
        final MenuChatItem menuChatItem2 = menuChatItem;
        MobilePhoneChatMenuItemBinding binding = holder.getBinding();
        binding.icon.setImageDrawable(ContextCompat.getDrawable(binding.getRoot().getContext(), menuChatItem2.getIcon()));
        binding.name.setText(menuChatItem2.getName());
        binding.name.setTextColor(menuChatItem2.getTextColor());
        holder.getBinding().getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerChatMenuAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onBindViewHolder$lambda$2;
                onBindViewHolder$lambda$2 = MobilePhoneMessengerChatMenuAdapter.onBindViewHolder$lambda$2(MobilePhoneMessengerChatMenuAdapter.this, menuChatItem2, view, motionEvent);
                return onBindViewHolder$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$2(MobilePhoneMessengerChatMenuAdapter mobilePhoneMessengerChatMenuAdapter, MenuChatItem menuChatItem, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setBackgroundColor(Color.parseColor("#ababab"));
            return true;
        } else if (action != 1) {
            return false;
        } else {
            view.setBackground(null);
            mobilePhoneMessengerChatMenuAdapter.onClickMenu.invoke(menuChatItem);
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.menuItems.size();
    }

    public final void addMenuItems(List<MenuChatItem> menuItems) {
        Intrinsics.checkNotNullParameter(menuItems, "menuItems");
        this.menuItems.addAll(menuItems);
        notifyDataSetChanged();
    }

    public final int changeMenuItem(MenuChatItem menuItem) {
        Object obj;
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Iterator<T> it = this.menuItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((MenuChatItem) obj).getId() == menuItem.getId()) {
                break;
            }
        }
        MenuChatItem menuChatItem = (MenuChatItem) obj;
        if (menuChatItem != null) {
            int indexOf = this.menuItems.indexOf(menuChatItem);
            this.menuItems.set(indexOf, menuItem);
            notifyItemChanged(indexOf);
            return indexOf;
        }
        return -1;
    }

    public final void clearMenuItems() {
        this.menuItems.clear();
    }
}
