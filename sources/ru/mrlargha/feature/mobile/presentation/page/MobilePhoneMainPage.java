package ru.mrlargha.feature.mobile.presentation.page;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MobilePhoneBinding;
import ru.mrlargha.feature.mobile.databinding.MobilePhoneMainPageBinding;
import ru.mrlargha.feature.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.feature.mobile.domain.obj.MobilePhoneCarousel;
import ru.mrlargha.feature.mobile.domain.obj.MobilePhoneMenu;
import ru.mrlargha.feature.mobile.presentation.HistoryManager;
import ru.mrlargha.feature.mobile.presentation.MobileController;
import ru.mrlargha.feature.mobile.presentation.adapter.ViewPageAdapter;
/* compiled from: MobilePhoneMainPage.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/MobilePhoneMainPage;", "Lru/mrlargha/feature/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/feature/mobile/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "timer", "Landroid/os/CountDownTimer;", "menus", "", "Lru/mrlargha/feature/mobile/domain/obj/MobilePhoneCarousel;", "mpMain", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMpMain", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mpMainBinding", "Lru/mrlargha/feature/mobile/databinding/MobilePhoneMainPageBinding;", "sharedPreferences", "Landroid/content/SharedPreferences;", "viewPagerAdapter", "Lru/mrlargha/feature/mobile/presentation/adapter/ViewPageAdapter;", "onApplicationOpened", "", "renderPage", "removePage", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobilePhoneMainPage implements MobileController {
    private final Activity context;
    private final List<MobilePhoneCarousel> menus;
    private final MobilePhone mobilePhone;
    private final ConstraintLayout mpMain;
    private final MobilePhoneMainPageBinding mpMainBinding;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;
    private final SharedPreferences sharedPreferences;
    private final CountDownTimer timer;
    private final ViewPageAdapter viewPagerAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [ru.mrlargha.feature.mobile.presentation.page.MobilePhoneMainPage$1] */
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
        MobilePhoneMenu[] mobilePhoneMenuArr = {new MobilePhoneMenu("Меню", R.drawable.mp_main_menu_ic, 1), new MobilePhoneMenu("Мой промокод", R.drawable.mp_promocode, 2), new MobilePhoneMenu("Квесты", R.drawable.mp_quest_ic, 3), new MobilePhoneMenu("Помощь", R.drawable.mp_help_ic, 15), new MobilePhoneMenu("Spotify", R.drawable.mp_music_ic, 5), new MobilePhoneMenu("Driver", R.drawable.mp_driver_ic, 6), new MobilePhoneMenu("Uber", R.drawable.mp_taxi_ic, 7), new MobilePhoneMenu("Навигатор", R.drawable.mp_navigator_ic, 8), new MobilePhoneMenu("Настройки", R.drawable.mp_settings_ic, 9), new MobilePhoneMenu("Звонки", R.drawable.mp_call_ic, 10), new MobilePhoneMenu("СМС", R.drawable.mp_sms_ic, 11), new MobilePhoneMenu("Контакты", R.drawable.mp_contact_ic, 12)};
        String string = context.getString(R.string.arizona_rent);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        MobilePhoneMenu[] mobilePhoneMenuArr2 = {new MobilePhoneMenu("Достижения", R.drawable.mp_achievements_ic, 13), new MobilePhoneMenu(string, R.drawable.mp_arizona_rent, 40), new MobilePhoneMenu("Магазин", R.drawable.mp_shop_ic, 14), new MobilePhoneMenu("Мед.карта", R.drawable.mp_medical_book_ic, 16), new MobilePhoneMenu("Паспорт", R.drawable.mp_passport_ic, 17), new MobilePhoneMenu("Анимации", R.drawable.mp_anims_ic, 18), new MobilePhoneMenu("Моя семья", R.drawable.mp_family_ic, 19), new MobilePhoneMenu("YouTube", R.drawable.mp_youtube_ic, 20), new MobilePhoneMenu("Бизнесы", R.drawable.mp_business_ic, 21), new MobilePhoneMenu("Авто", R.drawable.mp_auto, 22), new MobilePhoneMenu("Дома", R.drawable.mp_home_ic, 23), new MobilePhoneMenu("Банковское меню", R.drawable.mp_exchange_ic, 24)};
        MobilePhoneMenu[] mobilePhoneMenuArr3 = {new MobilePhoneMenu("Аренда билборда", R.drawable.mp_bilboard_ic, 25), new MobilePhoneMenu("Галерея", R.drawable.mp_camera_ic, 26), new MobilePhoneMenu("Звуки", R.drawable.mp_sound_settings_ic, 27), new MobilePhoneMenu("Режим погони", R.drawable.mp_copchase_ic, 28), new MobilePhoneMenu("Трезвый водитель", R.drawable.mp_soberdriver_ic, 29), new MobilePhoneMenu("Ловля", R.drawable.mp_catch_ic, 30), new MobilePhoneMenu("Селфи", R.drawable.mp_selfie_camera, 31), new MobilePhoneMenu("Телефонный справочник", R.drawable.mp_phone_number, 32), new MobilePhoneMenu("История ник-неймов,", R.drawable.mp_phone_nickname, 33), new MobilePhoneMenu("Календарь", R.drawable.mp_calendar_welcom, 34), new MobilePhoneMenu("Лог продаж", R.drawable.ic_marketplace_phone, 35), new MobilePhoneMenu("Хранилище", R.drawable.ic_storage_phone, 36)};
        String string2 = context.getString(R.string.rating_bp);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        List<MobilePhoneCarousel> listOf = CollectionsKt.listOf((Object[]) new MobilePhoneCarousel[]{new MobilePhoneCarousel(0, CollectionsKt.listOf((Object[]) mobilePhoneMenuArr)), new MobilePhoneCarousel(1, CollectionsKt.listOf((Object[]) mobilePhoneMenuArr2)), new MobilePhoneCarousel(2, CollectionsKt.listOf((Object[]) mobilePhoneMenuArr3)), new MobilePhoneCarousel(3, CollectionsKt.listOf((Object[]) new MobilePhoneMenu[]{new MobilePhoneMenu("Гонка вооружений", R.drawable.mobile_catch_app_ic, 37), new MobilePhoneMenu("Режим в полете", R.drawable.mp_avia, 38), new MobilePhoneMenu("Криптовалюта", R.drawable.mp_bitcoin_ic, 39), new MobilePhoneMenu("Рейтинг аксессуаров", R.drawable.mp_accs_rating_ic, 41), new MobilePhoneMenu("Рейтинг транспорта", R.drawable.mp_cars_rating_ic, 42), new MobilePhoneMenu(string2, R.drawable.mp_rating_bp, 43)}))});
        this.menus = listOf;
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_main_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.mpMain = constraintLayout;
        MobilePhoneMainPageBinding bind = MobilePhoneMainPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.mpMainBinding = bind;
        SharedPreferences sharedPreferences = context.getSharedPreferences(SAMPUIElement.SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(context, listOf, sharedPreferences.getInt("UNREAD_MESSAGE", 0));
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
        CountDownTimer start = new CountDownTimer(86400000L, 60000L) { // from class: ru.mrlargha.feature.mobile.presentation.page.MobilePhoneMainPage.1
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
        bind.mpMainPage.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.MobilePhoneMainPage$$ExternalSyntheticLambda0
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
        this.viewPagerAdapter.setOnApplicationClickListener(new ViewPageAdapter.OnApplicationClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.MobilePhoneMainPage$onApplicationOpened$1
            @Override // ru.mrlargha.feature.mobile.presentation.adapter.ViewPageAdapter.OnApplicationClickListener
            public void callback(String applicationName, int i) {
                IBackendNotifier iBackendNotifier;
                Intrinsics.checkNotNullParameter(applicationName, "applicationName");
                Log.d("uber", String.valueOf(i));
                iBackendNotifier = MobilePhoneMainPage.this.sendFrontedMessage;
                iBackendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
                switch (applicationName.hashCode()) {
                    case -334070118:
                        if (applicationName.equals("Spotify")) {
                            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId()).renderPage();
                            MobilePhoneMainPage.this.removePage();
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
                            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.UBER_PREVIEW.getId());
                            MobilePhoneMainPage.this.removePage();
                            return;
                        }
                        return;
                    case 935241912:
                        if (applicationName.equals("Звонки")) {
                            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_TYPE_PAGE.getId());
                            MobilePhoneMainPage.this.removePage();
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
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobileController
    public void removePage() {
        this.timer.cancel();
        HistoryManager.Companion.clearThisPage(MobilePhonePage.MAIN_PAGE.getId());
        this.viewPagerAdapter.cleanMenu();
        this.mpMain.removeAllViews();
    }
}
