package ru.mrlargha.commonui.elements.dialogs.playerlist;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.PlayerListDialogBinding;
import ru.mrlargha.commonui.elements.dialogs.AbstractDialog;
/* compiled from: PlayerListDialog.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\u0014\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/playerlist/PlayerListDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "", "sampDialogId", "<init>", "(Landroid/app/Activity;ILjava/lang/String;I)V", TtmlNode.TAG_LAYOUT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/PlayerListDialogBinding;", "players", "", "Lru/mrlargha/commonui/elements/dialogs/playerlist/Player;", "playerListAdapter", "Lru/mrlargha/commonui/elements/dialogs/playerlist/PlayersListAdapter;", "setServerName", "", "name", "submitPlayersList", "newPlayers", "isEditableBlank", "onLayoutClick", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayerListDialog extends AbstractDialog {
    private final PlayerListDialogBinding binding;
    private final View layout;
    private final PlayersListAdapter playerListAdapter;
    private List<Player> players;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerListDialog(final Activity targetActivity, int i, String caption, int i2) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Activity activity = targetActivity;
        View layout = LayoutInflater.from(activity).inflate(R.layout.player_list_dialog, (ViewGroup) null, false);
        this.layout = layout;
        final PlayerListDialogBinding bind = PlayerListDialogBinding.bind(layout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.players = CollectionsKt.emptyList();
        PlayersListAdapter playersListAdapter = new PlayersListAdapter();
        this.playerListAdapter = playersListAdapter;
        Intrinsics.checkNotNullExpressionValue(layout, "layout");
        addViewToConstraintLayout(layout, -1, -1);
        bind.tvCaption.setText(caption);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(bind.tvCaption, 8, 16, 1, 2);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(bind.tvPlayersCount, 8, 16, 1, 2);
        bind.rvPLayerList.setLayoutManager(new LinearLayoutManager(activity));
        bind.rvPLayerList.setAdapter(playersListAdapter);
        bind.rvPLayerList.setScrollbarFadingEnabled(false);
        bind.rvPLayerList.setScrollBarFadeDuration(0);
        TextInputEditText userInput = bind.userInput;
        Intrinsics.checkNotNullExpressionValue(userInput, "userInput");
        userInput.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog$_init_$lambda$8$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PlayersListAdapter playersListAdapter2;
                PlayersListAdapter playersListAdapter3;
                List list;
                Editable editable2;
                playersListAdapter2 = PlayerListDialog.this.playerListAdapter;
                playersListAdapter2.submitList(CollectionsKt.emptyList());
                if (StringsKt.isBlank(String.valueOf(editable))) {
                    PlayerListDialog.this.isEditableBlank();
                    return;
                }
                playersListAdapter3 = PlayerListDialog.this.playerListAdapter;
                list = PlayerListDialog.this.players;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    Player player = (Player) obj;
                    if (StringsKt.contains((CharSequence) player.getName(), (CharSequence) String.valueOf(editable), true) || StringsKt.contains$default((CharSequence) String.valueOf(player.getId()), (CharSequence) String.valueOf(editable), false, 2, (Object) null) || (editable2 = editable) == null || editable2.length() == 0) {
                        arrayList.add(obj);
                    }
                }
                playersListAdapter3.submitList(arrayList);
            }
        });
        bind.userInput.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayerListDialog.lambda$8$lambda$2(targetActivity, view, z);
            }
        });
        bind.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerListDialog.lambda$8$lambda$4(PlayerListDialog.this, bind, view);
            }
        });
        bind.userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return PlayerListDialog.lambda$8$lambda$5(targetActivity, bind, textView, i3, keyEvent);
            }
        });
        bind.rvPLayerList.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PlayerListDialog.lambda$8$lambda$6(targetActivity, view, motionEvent);
            }
        });
        bind.header.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.Companion.hideKeyboard(targetActivity);
            }
        });
        setVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$8$lambda$2(Activity activity, View view, boolean z) {
        if (z) {
            return;
        }
        SAMPUIElement.Companion.hideKeyboard(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$8$lambda$4(PlayerListDialog playerListDialog, PlayerListDialogBinding playerListDialogBinding, View view) {
        Editable text;
        PlayersListAdapter playersListAdapter = playerListDialog.playerListAdapter;
        ArrayList arrayList = new ArrayList();
        for (Object obj : playerListDialog.players) {
            Player player = (Player) obj;
            if (!StringsKt.contains((CharSequence) player.getName(), (CharSequence) String.valueOf(playerListDialogBinding.userInput.getText()), true)) {
                String textInputEditText = playerListDialogBinding.userInput.toString();
                Intrinsics.checkNotNullExpressionValue(textInputEditText, "toString(...)");
                if (!StringsKt.contains$default((CharSequence) String.valueOf(player.getId()), (CharSequence) textInputEditText, false, 2, (Object) null) && (text = playerListDialogBinding.userInput.getText()) != null && text.length() != 0) {
                }
            }
            arrayList.add(obj);
        }
        playersListAdapter.submitList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$8$lambda$5(Activity activity, PlayerListDialogBinding playerListDialogBinding, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || i == 6) {
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(playerListDialogBinding.userInput.getWindowToken(), 0);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$8$lambda$6(Activity activity, View view, MotionEvent motionEvent) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        return false;
    }

    public final void setServerName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.binding.tvCaption.setText(name);
    }

    public final void submitPlayersList(List<Player> newPlayers) {
        Intrinsics.checkNotNullParameter(newPlayers, "newPlayers");
        this.players = newPlayers;
        this.binding.tvPlayersCount.setText("Игроков: " + this.players.size());
        setVisibility(true);
        String valueOf = String.valueOf(this.binding.userInput.getText());
        if (!StringsKt.isBlank(valueOf)) {
            PlayersListAdapter playersListAdapter = this.playerListAdapter;
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.players) {
                if (StringsKt.contains((CharSequence) ((Player) obj).getName(), (CharSequence) valueOf, true) || valueOf == null || valueOf.length() == 0) {
                    arrayList.add(obj);
                }
            }
            playersListAdapter.submitList(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog$submitPlayersList$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((Player) t).getId()), Integer.valueOf(((Player) t2).getId()));
                }
            }));
        } else {
            isEditableBlank();
        }
        this.playerListAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void isEditableBlank() {
        List mutableList = CollectionsKt.toMutableList((Collection) this.players);
        if (mutableList.size() > 0) {
            List listOf = CollectionsKt.listOf(mutableList.get(0));
            mutableList.remove(0);
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog$isEditableBlank$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((Player) t).getId()), Integer.valueOf(((Player) t2).getId()));
                }
            });
            this.playerListAdapter.submitList(CollectionsKt.plus((Collection) listOf, (Iterable) mutableList));
            return;
        }
        this.playerListAdapter.submitList(mutableList);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onLayoutClick() {
        SAMPUIElement.Companion.hideKeyboard(getTargetActivity());
        setVisibility(false);
    }

    /* compiled from: PlayerListDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/playerlist/PlayerListDialog$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new PlayerListDialog(targetActivity, i, "Arizona RP Server", -1);
        }
    }
}
