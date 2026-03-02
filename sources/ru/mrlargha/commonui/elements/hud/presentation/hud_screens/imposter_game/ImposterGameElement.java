package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementImposterGameBinding;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudListener;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: ImposterGame.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u0016\u0010\u001c\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020 H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/imposter_game/ImposterGameElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementImposterGameBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "hudListener", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudListener;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementImposterGameBinding;Lru/mrlargha/commonui/core/SAMPUIElement;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudListener;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementImposterGameBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "getHudListener", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudListener;", "url", "", "getUrl", "()Ljava/lang/String;", "timer", "Landroid/os/CountDownTimer;", "setVisible", "", "data", "close", "setItemsList", "setPlayerInfo", "setItems", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/imposter_game/ImposterGameToolItem;", "setInfo", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/imposter_game/ImposterGameRoleItem;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ImposterGameElement {
    private final HudElementImposterGameBinding binding;
    private final HudListener hudListener;
    private final SAMPUIElement notifier;
    private CountDownTimer timer;
    private final String url;

    public ImposterGameElement(HudElementImposterGameBinding binding, SAMPUIElement notifier, HudListener hudListener) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        Intrinsics.checkNotNullParameter(hudListener, "hudListener");
        this.binding = binding;
        this.notifier = notifier;
        this.hudListener = hudListener;
        this.url = "projects/arizona-rp/systems/lockdown_protocol/items/";
    }

    public final HudElementImposterGameBinding getBinding() {
        return this.binding;
    }

    public final HudListener getHudListener() {
        return this.hudListener;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setVisible(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        boolean areEqual = Intrinsics.areEqual(data, "1");
        HudElementImposterGameBinding hudElementImposterGameBinding = this.binding;
        if (areEqual) {
            hudElementImposterGameBinding.getRoot().setVisibility(0);
            return;
        }
        hudElementImposterGameBinding.getRoot().setVisibility(8);
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
        this.hudListener.hudSetTimer(0);
    }

    public final void close() {
        setVisible("false");
    }

    private final void setItems(List<ImposterGameToolItem> list) {
        this.binding.hudImposterGameItem1Image.setImageBitmap(null);
        ImposterGameToolItem imposterGameToolItem = (ImposterGameToolItem) CollectionsKt.getOrNull(list, 0);
        if (imposterGameToolItem != null) {
            if (imposterGameToolItem.getId() != -1) {
                Picasso picasso = Picasso.get();
                String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
                String str = this.url;
                picasso.load(resourceUrl$default + str + imposterGameToolItem.getImage()).into(this.binding.hudImposterGameItem1Image);
            }
            int selected = imposterGameToolItem.getSelected();
            HudElementImposterGameBinding hudElementImposterGameBinding = this.binding;
            if (selected == 1) {
                CustomCardView hudImposterGameItem1 = hudElementImposterGameBinding.hudImposterGameItem1;
                Intrinsics.checkNotNullExpressionValue(hudImposterGameItem1, "hudImposterGameItem1");
                CustomCardView.setBorder$default(hudImposterGameItem1, Color.parseColor("#B331FF2D"), 0, null, 4, null);
                this.binding.hudImposterGameItem1Used.setVisibility(0);
            } else {
                CustomCardView hudImposterGameItem12 = hudElementImposterGameBinding.hudImposterGameItem1;
                Intrinsics.checkNotNullExpressionValue(hudImposterGameItem12, "hudImposterGameItem1");
                CustomCardView.setBorder$default(hudImposterGameItem12, Color.parseColor("#1AFFFFFF"), 0, null, 4, null);
                this.binding.hudImposterGameItem1Used.setVisibility(8);
            }
        }
        this.binding.hudImposterGameItem2Image.setImageBitmap(null);
        ImposterGameToolItem imposterGameToolItem2 = (ImposterGameToolItem) CollectionsKt.getOrNull(list, 1);
        if (imposterGameToolItem2 != null) {
            if (imposterGameToolItem2.getId() != -1) {
                Picasso picasso2 = Picasso.get();
                String resourceUrl$default2 = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
                String str2 = this.url;
                picasso2.load(resourceUrl$default2 + str2 + imposterGameToolItem2.getImage()).into(this.binding.hudImposterGameItem2Image);
            }
            int selected2 = imposterGameToolItem2.getSelected();
            HudElementImposterGameBinding hudElementImposterGameBinding2 = this.binding;
            if (selected2 == 1) {
                CustomCardView hudImposterGameItem2 = hudElementImposterGameBinding2.hudImposterGameItem2;
                Intrinsics.checkNotNullExpressionValue(hudImposterGameItem2, "hudImposterGameItem2");
                CustomCardView.setBorder$default(hudImposterGameItem2, Color.parseColor("#B331FF2D"), 0, null, 4, null);
                this.binding.hudImposterGameItem2Used.setVisibility(0);
            } else {
                CustomCardView hudImposterGameItem22 = hudElementImposterGameBinding2.hudImposterGameItem2;
                Intrinsics.checkNotNullExpressionValue(hudImposterGameItem22, "hudImposterGameItem2");
                CustomCardView.setBorder$default(hudImposterGameItem22, Color.parseColor("#1AFFFFFF"), 0, null, 4, null);
                this.binding.hudImposterGameItem2Used.setVisibility(8);
            }
        }
        this.binding.hudImposterGameItem1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game.ImposterGameElement$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(ImposterGameElement.this.notifier, 74, 74, null, 4, null);
            }
        });
        this.binding.hudImposterGameItem2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game.ImposterGameElement$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(ImposterGameElement.this.notifier, 75, 75, null, 4, null);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game.ImposterGameElement$setInfo$1] */
    private final void setInfo(ImposterGameRoleItem imposterGameRoleItem) {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
        final long timerValue = imposterGameRoleItem.getTimerValue() * 1000;
        this.timer = new CountDownTimer(timerValue) { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game.ImposterGameElement$setInfo$1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                ImposterGameElement.this.getHudListener().hudSetTimer((int) (j / 1000));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ImposterGameElement.this.getHudListener().hudSetTimer(0);
                cancel();
            }
        }.start();
        this.binding.zoneType.setImageResource(imposterGameRoleItem.isZoneType() == 1 ? R.drawable.hud_imposter_zone_red : R.drawable.hud_imposter_zone_green);
        this.binding.hudImposterGamePersonValue.setText(String.valueOf(imposterGameRoleItem.getCountWorker()));
        this.binding.hudImposterGameImposterValue.setText(String.valueOf(imposterGameRoleItem.getCountImposter()));
        this.binding.hudImposterGameRoleText.setText(imposterGameRoleItem.getName());
        int type = imposterGameRoleItem.getType();
        HudElementImposterGameBinding hudElementImposterGameBinding = this.binding;
        if (type == 1) {
            hudElementImposterGameBinding.hudImposterGameRoleImage.setImageResource(R.drawable.hud_imposter_game_imposter_ic);
            CustomCardView hudImposterGameRole = this.binding.hudImposterGameRole;
            Intrinsics.checkNotNullExpressionValue(hudImposterGameRole, "hudImposterGameRole");
            CustomCardView.setBackground$default(hudImposterGameRole, Color.parseColor("#FF4546"), 0, null, null, 12, null);
        } else {
            hudElementImposterGameBinding.hudImposterGameRoleImage.setImageResource(R.drawable.hud_imposter_game_worker_ic);
            CustomCardView hudImposterGameRole2 = this.binding.hudImposterGameRole;
            Intrinsics.checkNotNullExpressionValue(hudImposterGameRole2, "hudImposterGameRole");
            CustomCardView.setBackground$default(hudImposterGameRole2, Color.parseColor("#31FF2D"), 0, null, null, 12, null);
        }
        this.binding.hudImposterGameTasks.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game.ImposterGameElement$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(ImposterGameElement.this.notifier, 73, 73, null, 4, null);
            }
        });
        this.binding.hudImposterGameTrash.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game.ImposterGameElement$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(ImposterGameElement.this.notifier, 76, 76, null, 4, null);
            }
        });
    }

    public final void setItemsList(String data) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (MapperKt.isJsonValid(data)) {
                Gson create = new GsonBuilder().setLenient().create();
                JsonArray asJsonArray = ((JsonElement) create.fromJson(data, (Class<Object>) JsonElement.class)).getAsJsonArray();
                Intrinsics.checkNotNull(asJsonArray);
                JsonArray<JsonElement> jsonArray = asJsonArray;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                for (JsonElement jsonElement : jsonArray) {
                    arrayList2.add(create.fromJson(jsonElement, (Class<Object>) ImposterGameToolItem.class));
                }
                arrayList = arrayList2;
            } else {
                arrayList = CollectionsKt.emptyList();
            }
            setItems(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            this.binding.getRoot().setVisibility(8);
        }
    }

    public final void setPlayerInfo(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (MapperKt.isJsonValid(data)) {
                setInfo((ImposterGameRoleItem) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) ImposterGameRoleItem.class));
                return;
            }
            throw new JsonParseException("Json is not valid");
        } catch (Exception e) {
            e.printStackTrace();
            this.binding.getRoot().setVisibility(8);
        }
    }
}
