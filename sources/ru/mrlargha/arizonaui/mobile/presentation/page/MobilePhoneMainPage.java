package ru.mrlargha.arizonaui.mobile.presentation.page;

import android.app.Activity;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneMainPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneCarousel;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneMenu;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.ViewPageAdapter;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: MobilePhoneMainPage.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/MobilePhoneMainPage;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "timer", "Landroid/os/CountDownTimer;", "menus", "", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneCarousel;", "mpMain", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMpMain", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mpMainBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneMainPageBinding;", "viewPagerAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/ViewPageAdapter;", "onApplicationOpened", "", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneMainPage implements MobileController {
    private final Activity context;
    private final List<MobilePhoneCarousel> menus;
    private final MobilePhone mobilePhone;
    private final ConstraintLayout mpMain;
    private final MobilePhoneMainPageBinding mpMainBinding;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;
    private final CountDownTimer timer;
    private final ViewPageAdapter viewPagerAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [ru.mrlargha.arizonaui.mobile.presentation.page.MobilePhoneMainPage$1] */
    public MobilePhoneMainPage() {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MOBILE_PHONE_PAGE.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.MobilePhone");
        MobilePhone mobilePhone = (MobilePhone) orCreatePage;
        this.mobilePhone = mobilePhone;
        Activity context = mobilePhone.getContext();
        this.context = context;
        MobilePhoneBinding binding = mobilePhone.getBinding();
        this.phoneBinding = binding;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.sendFrontedMessage = (IBackendNotifier) context;
        List<MobilePhoneCarousel> listOf = CollectionsKt.listOf((Object[]) new MobilePhoneCarousel[]{new MobilePhoneCarousel(0, CollectionsKt.listOf((Object[]) new MobilePhoneMenu[]{new MobilePhoneMenu("Меню", R.drawable.mp_main_menu_ic), new MobilePhoneMenu("Помощь", R.drawable.mp_help_ic), new MobilePhoneMenu("Квесты", R.drawable.mp_quest_ic), new MobilePhoneMenu("Репорт", R.drawable.mp_report_ic), new MobilePhoneMenu("Spotify", R.drawable.mp_music_ic), new MobilePhoneMenu("Driver", R.drawable.mp_driver_ic), new MobilePhoneMenu("Uber", R.drawable.mp_taxi_ic), new MobilePhoneMenu("Навигатор", R.drawable.mp_navigator_ic), new MobilePhoneMenu("Настройки", R.drawable.mp_settings_ic), new MobilePhoneMenu("Звонки", R.drawable.mp_call_ic), new MobilePhoneMenu("СМС", R.drawable.mp_sms_ic), new MobilePhoneMenu("Контакты", R.drawable.mp_contact_ic)})), new MobilePhoneCarousel(1, CollectionsKt.listOf((Object[]) new MobilePhoneMenu[]{new MobilePhoneMenu("Достижения", R.drawable.mp_achievements_ic), new MobilePhoneMenu("Магазин", R.drawable.mp_shop_ic), new MobilePhoneMenu("Криптовалюта", R.drawable.mp_bitcoin_ic), new MobilePhoneMenu("Мед.карта", R.drawable.mp_medical_book_ic), new MobilePhoneMenu("Паспорт", R.drawable.mp_passport_ic), new MobilePhoneMenu("Анимации", R.drawable.mp_anims_ic), new MobilePhoneMenu("Моя семья", R.drawable.mp_family_ic), new MobilePhoneMenu("YouTube", R.drawable.mp_youtube_ic), new MobilePhoneMenu("Бизнесы", R.drawable.mp_business_ic), new MobilePhoneMenu("Дома", R.drawable.mp_home_ic), new MobilePhoneMenu("Банковское меню", R.drawable.mp_exchange_ic)})), new MobilePhoneCarousel(2, CollectionsKt.listOf((Object[]) new MobilePhoneMenu[]{new MobilePhoneMenu("Аренда билборда", R.drawable.mp_bilboard_ic), new MobilePhoneMenu("Галерея", R.drawable.mp_camera_ic), new MobilePhoneMenu("Звуки", R.drawable.mp_sound_settings_ic), new MobilePhoneMenu("Режим погони", R.drawable.mp_copchase_ic), new MobilePhoneMenu("Трезвый водитель", R.drawable.mp_soberdriver_ic), new MobilePhoneMenu("Ловля", R.drawable.mp_catch_ic), new MobilePhoneMenu("Селфи", R.drawable.mp_selfie_camera), new MobilePhoneMenu("Телефонный справочник", R.drawable.mp_phone_number), new MobilePhoneMenu("История ник-неймов,", R.drawable.mp_phone_nickname), new MobilePhoneMenu("Новогодний календарь", R.drawable.mp_calendar_may), new MobilePhoneMenu("Лог продаж", R.drawable.ic_marketplace_phone), new MobilePhoneMenu("Хранилище", R.drawable.ic_storage_phone)}))});
        this.menus = listOf;
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_main_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.mpMain = constraintLayout;
        MobilePhoneMainPageBinding bind = MobilePhoneMainPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.mpMainBinding = bind;
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(context, listOf);
        this.viewPagerAdapter = viewPageAdapter;
        Log.d("text", ": Main page created");
        HistoryManager.Companion.push(MobilePhonePage.MAIN_PAGE.getId());
        binding.phoneBackground.setBackground(mobilePhone.getBackground());
        binding.phoneCaseContainer.addView(bind.mpMainPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpMainPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4, 8);
        constraintSet.connect(bind.mpMainPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpMainPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.applyTo(binding.phoneCaseContainer);
        bind.phoneMenuPager.setAdapter(viewPageAdapter);
        bind.phoneMenuPager.setOrientation(0);
        bind.phoneMenuPagerIndicator.setViewPager(bind.phoneMenuPager);
        bind.phoneDate.setText(new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date()));
        CountDownTimer start = new CountDownTimer(CalendarModelKt.MillisecondsIn24Hours, 60000L) { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.MobilePhoneMainPage.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                this.mpMainBinding.phoneTimeBar.setText(this.phoneBinding.phoneTopBarTime.getText());
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                cancel();
            }
        }.start();
        Intrinsics.checkNotNullExpressionValue(start, "start(...)");
        this.timer = start;
        bind.mpMainPage.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.MobilePhoneMainPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneMainPage._init_$lambda$0(view);
            }
        });
        onApplicationOpened();
    }

    public final ConstraintLayout getMpMain() {
        return this.mpMain;
    }

    public final void onApplicationOpened() {
        this.viewPagerAdapter.setOnApplicationClickListener(new ViewPageAdapter.OnApplicationClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.MobilePhoneMainPage$onApplicationOpened$1
            @Override // ru.mrlargha.arizonaui.mobile.presentation.adapter.ViewPageAdapter.OnApplicationClickListener
            public void callback(String applicationName, int i) {
                IBackendNotifier iBackendNotifier;
                IBackendNotifier iBackendNotifier2;
                IBackendNotifier iBackendNotifier3;
                IBackendNotifier iBackendNotifier4;
                IBackendNotifier iBackendNotifier5;
                IBackendNotifier iBackendNotifier6;
                IBackendNotifier iBackendNotifier7;
                IBackendNotifier iBackendNotifier8;
                IBackendNotifier iBackendNotifier9;
                IBackendNotifier iBackendNotifier10;
                IBackendNotifier iBackendNotifier11;
                IBackendNotifier iBackendNotifier12;
                IBackendNotifier iBackendNotifier13;
                IBackendNotifier iBackendNotifier14;
                IBackendNotifier iBackendNotifier15;
                IBackendNotifier iBackendNotifier16;
                IBackendNotifier iBackendNotifier17;
                IBackendNotifier iBackendNotifier18;
                IBackendNotifier iBackendNotifier19;
                IBackendNotifier iBackendNotifier20;
                IBackendNotifier iBackendNotifier21;
                IBackendNotifier iBackendNotifier22;
                IBackendNotifier iBackendNotifier23;
                IBackendNotifier iBackendNotifier24;
                IBackendNotifier iBackendNotifier25;
                IBackendNotifier iBackendNotifier26;
                IBackendNotifier iBackendNotifier27;
                IBackendNotifier iBackendNotifier28;
                IBackendNotifier iBackendNotifier29;
                IBackendNotifier iBackendNotifier30;
                IBackendNotifier iBackendNotifier31;
                IBackendNotifier iBackendNotifier32;
                IBackendNotifier iBackendNotifier33;
                IBackendNotifier iBackendNotifier34;
                Intrinsics.checkNotNullParameter(applicationName, "applicationName");
                switch (applicationName.hashCode()) {
                    case -1937019758:
                        if (applicationName.equals("Бизнесы")) {
                            iBackendNotifier = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case -1708839608:
                        if (applicationName.equals("Криптовалюта")) {
                            iBackendNotifier2 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier2.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case -1490767609:
                        if (applicationName.equals("Анимации")) {
                            iBackendNotifier3 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier3.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case -997526805:
                        if (applicationName.equals("Магазин")) {
                            iBackendNotifier4 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier4.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case -952418360:
                        if (applicationName.equals("Достижения")) {
                            iBackendNotifier5 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier5.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case -765791404:
                        if (applicationName.equals("Трезвый водитель")) {
                            iBackendNotifier6 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier6.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case -609875939:
                        if (applicationName.equals("Телефонный справочник")) {
                            iBackendNotifier7 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier7.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case -387579645:
                        if (applicationName.equals("Галерея")) {
                            iBackendNotifier8 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier8.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case -334070118:
                        if (applicationName.equals("Spotify")) {
                            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId()).renderPage();
                            MobilePhoneMainPage.this.removePage();
                            iBackendNotifier9 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier9.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    case -206354084:
                        if (applicationName.equals("Контакты")) {
                            iBackendNotifier10 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier10.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    case -106900903:
                        if (applicationName.equals("Хранилище")) {
                            iBackendNotifier11 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier11.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 1049446:
                        if (applicationName.equals("СМС")) {
                            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_APP.getId()).renderPage();
                            MobilePhoneMainPage.this.removePage();
                            return;
                        }
                        return;
                    case 2629658:
                        if (applicationName.equals("Uber")) {
                            Log.d("uber", "openUberPreview");
                            iBackendNotifier12 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier12.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.UBER_PREVIEW.getId());
                            MobilePhoneMainPage.this.removePage();
                            return;
                        }
                        return;
                    case 32180126:
                        if (applicationName.equals("Дома")) {
                            iBackendNotifier13 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier13.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), 22, 0);
                            return;
                        }
                        return;
                    case 32409866:
                        if (applicationName.equals("Меню")) {
                            iBackendNotifier14 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier14.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    case 219755905:
                        if (applicationName.equals("История ник-неймов,")) {
                            iBackendNotifier15 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier15.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 240367590:
                        if (applicationName.equals("Маркетплейс")) {
                            iBackendNotifier16 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier16.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 671954723:
                        if (applicationName.equals("YouTube")) {
                            iBackendNotifier17 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier17.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case 859900293:
                        if (applicationName.equals("Мед.карта")) {
                            iBackendNotifier18 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier18.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case 935241912:
                        if (applicationName.equals("Звонки")) {
                            iBackendNotifier19 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier19.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_TYPE_PAGE.getId());
                            MobilePhoneMainPage.this.removePage();
                            return;
                        }
                        return;
                    case 979596910:
                        if (applicationName.equals("Навигатор")) {
                            iBackendNotifier20 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier20.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    case 1000005094:
                        if (applicationName.equals("Звуки")) {
                            iBackendNotifier21 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier21.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 1004040387:
                        if (applicationName.equals("Ловля")) {
                            iBackendNotifier22 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier22.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 1009322299:
                        if (applicationName.equals("Селфи")) {
                            iBackendNotifier23 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier23.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 1020865357:
                        if (applicationName.equals("Квесты")) {
                            iBackendNotifier24 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier24.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    case 1175299236:
                        if (applicationName.equals("Помощь")) {
                            iBackendNotifier25 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier25.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    case 1195705782:
                        if (applicationName.equals("Репорт")) {
                            iBackendNotifier26 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier26.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    case 1204476576:
                        if (applicationName.equals("Режим погони")) {
                            iBackendNotifier27 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier27.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 1375207383:
                        if (applicationName.equals("Новогодний календарь")) {
                            iBackendNotifier28 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier28.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 1458889016:
                        if (applicationName.equals("Моя семья")) {
                            iBackendNotifier29 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier29.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case 1470746695:
                        if (applicationName.equals("Аренда билборда")) {
                            iBackendNotifier30 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier30.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 24, 0);
                            return;
                        }
                        return;
                    case 1678367377:
                        if (applicationName.equals("Паспорт")) {
                            iBackendNotifier31 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier31.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i + 12, 0);
                            return;
                        }
                        return;
                    case 1705955813:
                        if (applicationName.equals("Настройки")) {
                            iBackendNotifier32 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier32.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    case 2038453418:
                        if (applicationName.equals("Банковское меню")) {
                            iBackendNotifier33 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier33.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), 23, 0);
                            return;
                        }
                        return;
                    case 2055308360:
                        if (applicationName.equals("Driver")) {
                            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
                            if (pageIfExist != null) {
                                pageIfExist.removePage();
                            }
                            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.DRIVER_ORDERS.getId());
                            iBackendNotifier34 = MobilePhoneMainPage.this.sendFrontedMessage;
                            iBackendNotifier34.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        this.timer.cancel();
        HistoryManager.Companion.clearThisPage(MobilePhonePage.MAIN_PAGE.getId());
        this.viewPagerAdapter.cleanMenu();
        this.mpMain.removeAllViews();
    }
}
