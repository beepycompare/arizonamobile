package ru.mrlargha.commonui.utils.emoji;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.text.util.LocalePreferences;
import androidx.media3.common.C;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.messaging.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import ru.mrlargha.commonui.R;
/* compiled from: ChatEmoji.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u0018*\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\n\u0010\u001d\u001a\u00020\u0018*\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/utils/emoji/ChatEmoji;", "", "<init>", "()V", "iconFont", "Landroid/graphics/Typeface;", "namedTags", "", "", "", "getNamedTags", "()Ljava/util/Map;", "validCp", "", "cp", "parseEmojiInText", "text", "", "init", "", "context", "Landroid/content/Context;", "isCustomCp", "applyIconFont", "Landroid/text/SpannableString;", "spannable", "iconScale", "", "toSpannable", "tagsColor", "IconTypefaceSpan", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatEmoji {
    private static Typeface iconFont;
    public static final ChatEmoji INSTANCE = new ChatEmoji();
    private static final Map<String, Integer> namedTags = MapsKt.mapOf(TuplesKt.to("joy", 128514), TuplesKt.to("rofl", 129315), TuplesKt.to("smiley", 128515), TuplesKt.to("smile", 128516), TuplesKt.to("sweat", 128517), TuplesKt.to("xd", 128518), TuplesKt.to("yum", 128523), TuplesKt.to("heart_eyes", 128525), TuplesKt.to("love", 129392), TuplesKt.to("kissing", 128535), TuplesKt.to("hugging", 129303), TuplesKt.to("starstruck", 129321), TuplesKt.to("thinking", 129300), TuplesKt.to("salut", 129761), TuplesKt.to("what", 129320), TuplesKt.to("muted", 128566), TuplesKt.to("dotted", 129765), TuplesKt.to("rolleye", 128580), TuplesKt.to("smirk", 128527), TuplesKt.to("sad", 128549), TuplesKt.to("zipper", 129296), TuplesKt.to("hushed", 128559), TuplesKt.to("sleepy", 128554), TuplesKt.to("tired", 128555), TuplesKt.to("yawn", 129393), TuplesKt.to("zzz", 128564), TuplesKt.to("relieved", 128524), TuplesKt.to("drooling", 129316), TuplesKt.to("bruh", 128530), TuplesKt.to("pensive", 128532), TuplesKt.to("melt", 129760), TuplesKt.to("money", 129297), TuplesKt.to("astonished", 128562), TuplesKt.to("pained", 128542), TuplesKt.to("worried", 128543), TuplesKt.to("triumph", 128548), TuplesKt.to("sob", 128557), TuplesKt.to("frowning", 128550), TuplesKt.to("anguished", 128551), TuplesKt.to("fearful", 128552), TuplesKt.to("weary", 128553), TuplesKt.to("fyp", 129327), TuplesKt.to("grimacing", 128556), TuplesKt.to("anxious", 128560), TuplesKt.to("scream", 128561), TuplesKt.to("hot", 129397), TuplesKt.to("cold", 129398), TuplesKt.to("zany", 129322), TuplesKt.to("dizzy", 128565), TuplesKt.to("woozy", 129396), TuplesKt.to("angry", 128544), TuplesKt.to("rage", 128545), TuplesKt.to("swear", 129324), TuplesKt.to("mask", 128567), TuplesKt.to("bandage", 129301), TuplesKt.to("nauseated", 129314), TuplesKt.to("vomit", 129326), TuplesKt.to("tissue", 129319), TuplesKt.to("halo", 128519), TuplesKt.to("party", 129395), TuplesKt.to("albert", 129400), TuplesKt.to("cowboy", 129312), TuplesKt.to("clown", 129313), TuplesKt.to("lying", 129317), TuplesKt.to("shush", 129323), TuplesKt.to("monocle", 129488), TuplesKt.to("nerd", 129299), TuplesKt.to("horns", 128520), TuplesKt.to("imp", 128127), TuplesKt.to("ogre", 128121), TuplesKt.to("goblin", 128122), TuplesKt.to("skull", 128128), TuplesKt.to("ghost", 128123), TuplesKt.to("alien", 128125), TuplesKt.to("alienm", 128126), TuplesKt.to("robot", 129302), TuplesKt.to("poo", 128169), TuplesKt.to("cat", 128570), TuplesKt.to("smile_cat", 128568), TuplesKt.to("joy_cat", 128569), TuplesKt.to("smirk_cat", 128572), TuplesKt.to("scream_cat", 128576), TuplesKt.to("monkey", 128053), TuplesKt.to("dog", 128054), TuplesKt.to("wolf", 128058), TuplesKt.to("lion", 129409), TuplesKt.to("tiger", 128047), TuplesKt.to("giraffe", 129426), TuplesKt.to("fox", 129418), TuplesKt.to("raccoon", 129437), TuplesKt.to("cow", 128046), TuplesKt.to("pig", 128055), TuplesKt.to("boar", 128023), TuplesKt.to("mouse", 128045), TuplesKt.to("hamster", 128057), TuplesKt.to("rabbit", 128048), TuplesKt.to("bear", 128059), TuplesKt.to("koala", 128040), TuplesKt.to("panda", 128060), TuplesKt.to("frog", 128056), TuplesKt.to("zebra", 129427), TuplesKt.to("horse", 128052), TuplesKt.to("unicorn", 129412), TuplesKt.to("chicken", 128020), TuplesKt.to("pig_nose", 128061), TuplesKt.to("feet", 128062), TuplesKt.to("monkey2", 128018), TuplesKt.to("gorilla", 129421), TuplesKt.to("orangutan", 129447), TuplesKt.to("guide_dog", 129454), TuplesKt.to("poodle", 128041), TuplesKt.to("dog2", 128021), TuplesKt.to("cat2", 128008), TuplesKt.to("tiger2", 128005), TuplesKt.to("leopard", 128006), TuplesKt.to("racehorse", 128014), TuplesKt.to("deer", 129420), TuplesKt.to("rhinoceros", 129423), TuplesKt.to("ox", 128002), TuplesKt.to("cow2", 128004), TuplesKt.to("pig2", 128022), TuplesKt.to("ram", 128015), TuplesKt.to("sheep", 128017), TuplesKt.to("goat", 128016), TuplesKt.to("camel", 128043), TuplesKt.to("llama", 129433), TuplesKt.to("kangaroo", 129432), TuplesKt.to("sloth", 129445), TuplesKt.to("skunk", 129448), TuplesKt.to("badger", 129441), TuplesKt.to("elephant", 128024), TuplesKt.to("mouse2", 128001), TuplesKt.to("rat", 128000), TuplesKt.to("hedgehog", 129428), TuplesKt.to("rabbit2", 128007), TuplesKt.to("chipmunk", 128063), TuplesKt.to("lizard", 129422), TuplesKt.to("crocodile", 128010), TuplesKt.to("turtle", 128034), TuplesKt.to("snake", 128013), TuplesKt.to("dragon", 128009), TuplesKt.to("sauropod", 129429), TuplesKt.to("trex", 129430), TuplesKt.to("otter", 129446), TuplesKt.to("shark", 129416), TuplesKt.to("dolphin", 128044), TuplesKt.to("whale", 128051), TuplesKt.to("whale2", 128011), TuplesKt.to("fish", 128031), TuplesKt.to("blowfish", 128033), TuplesKt.to("shrimp", 129424), TuplesKt.to("squid", 129425), TuplesKt.to("octopus", 128025), TuplesKt.to("lobster", 129438), TuplesKt.to("crab", 129408), TuplesKt.to("shell", 128026), TuplesKt.to("duck", 129414), TuplesKt.to("cock", 128019), TuplesKt.to("turkey", 129411), TuplesKt.to("eagle", 129413), TuplesKt.to("dove", 128330), TuplesKt.to("swan", 129442), TuplesKt.to("parrot", 129436), TuplesKt.to("flamingo", 129449), TuplesKt.to("peacock", 129434), TuplesKt.to("owl", 129417), TuplesKt.to("bird", 128038), TuplesKt.to("penguin", 128039), TuplesKt.to("chick", 128036), TuplesKt.to("bat", 129415), TuplesKt.to("butterfly", 129419), TuplesKt.to("snail", 128012), TuplesKt.to("mosquito", 129439), TuplesKt.to("fly", 129712), TuplesKt.to("worm", 129713), TuplesKt.to("cricket", 129431), TuplesKt.to("ant", 128028), TuplesKt.to("bee", 128029), TuplesKt.to("beetle", 129714), TuplesKt.to("bug", 128030), TuplesKt.to("scorpion", 129410), TuplesKt.to("spider", 128375), TuplesKt.to("spider_web", 128376), TuplesKt.to("microbe", 129440), TuplesKt.to("genie", 129502), TuplesKt.to("zombie", 129503), TuplesKt.to("eye", 128065), TuplesKt.to("eyes", 128064), TuplesKt.to("bone", 129460), TuplesKt.to("tooth", 129463), TuplesKt.to("tongue", 128069), TuplesKt.to("lips", 128068), TuplesKt.to("brain", 129504), TuplesKt.to("footprints", 128099), TuplesKt.to("skier", 9975), TuplesKt.to("woman", 128105), TuplesKt.to("man", 128104), TuplesKt.to("person", 129489), TuplesKt.to("girl", 128103), TuplesKt.to("boy", 128102), TuplesKt.to("child", 129490), TuplesKt.to("baby", 128118), TuplesKt.to("older_woman", 128117), TuplesKt.to("older_man", 128116), TuplesKt.to("princess", 128120), TuplesKt.to("prince", 129332), TuplesKt.to("turban", 128115), TuplesKt.to("beard", 129492), TuplesKt.to("angel", 128124), TuplesKt.to("santa", 127877), TuplesKt.to("cop", 128110), TuplesKt.to("detective", 128373), TuplesKt.to("guardsman", 128130), TuplesKt.to("superhero", 129464), TuplesKt.to("mage", 129497), TuplesKt.to("fairy", 129498), TuplesKt.to("vampire", 129499), TuplesKt.to("merperson", 129500), TuplesKt.to("elf", 129501), TuplesKt.to("no_good", 128581), TuplesKt.to("ok1", 128582), TuplesKt.to("bow", 128583), TuplesKt.to("massage", 128134), TuplesKt.to("haircut", 128135), TuplesKt.to("walking", 128694), TuplesKt.to("runner", 127939), TuplesKt.to("dancer", 128131), TuplesKt.to("bath", 128704), TuplesKt.to("golfer", 127948), TuplesKt.to("surfer", 127940), TuplesKt.to("rowboat", 128675), TuplesKt.to("swimmer", 127946), TuplesKt.to("bicyclist", 128692), TuplesKt.to("selfie", 129331), TuplesKt.to("muscle", 128170), TuplesKt.to("leg", 129461), TuplesKt.to("foot", 129462), TuplesKt.to("ear", 128066), TuplesKt.to("nose", 128067), TuplesKt.to(TtmlNode.LEFT, 128072), TuplesKt.to(TtmlNode.RIGHT, 128073), TuplesKt.to("up1", 9757), TuplesKt.to("up", 128070), TuplesKt.to("down", 128071), TuplesKt.to("v", 9996), TuplesKt.to("fuck", 128405), TuplesKt.to("rock", 129304), TuplesKt.to(NotificationCompat.CATEGORY_CALL, 129305), TuplesKt.to("ok", 128076), TuplesKt.to("+", 128077), TuplesKt.to(Constants.FILENAME_SEQUENCE_SEPARATOR, 128078), TuplesKt.to("fist", 9994), TuplesKt.to("wave", 128075), TuplesKt.to("clap", 128079), TuplesKt.to("open_hands", 128080), TuplesKt.to("hheart", 129782), TuplesKt.to("pray", 128591), TuplesKt.to("handshake", 129309), TuplesKt.to("nails", 128133), TuplesKt.to("dancers", 128111), TuplesKt.to("balloon", 127880), TuplesKt.to("fireworks", 127878), TuplesKt.to("sparkler", 127879), TuplesKt.to("sparkles", 10024), TuplesKt.to("tada", 127881), TuplesKt.to("bamboo", 127885), TuplesKt.to("dolls", 127886), TuplesKt.to(DownloaderServiceMarshaller.PARAMS_FLAGS, 127887), TuplesKt.to("wind_chime", 127888), TuplesKt.to("rice_scene", 127889), TuplesKt.to("ribbon", 127872), TuplesKt.to("gift", 127873), TuplesKt.to("ticket", 127915), TuplesKt.to("thread", 129525), TuplesKt.to("yarn", 129526), TuplesKt.to("eyeglasses", 128083), TuplesKt.to("goggles", 129405), TuplesKt.to("lab_coat", 129404), TuplesKt.to("coat", 129509), TuplesKt.to("necktie", 128084), TuplesKt.to("shirt", 128085), TuplesKt.to("jeans", 128086), TuplesKt.to("shorts", 129651), TuplesKt.to("scarf", 129507), TuplesKt.to("gloves", 129508), TuplesKt.to("socks", 129510), TuplesKt.to("dress", 128087), TuplesKt.to("sari", 129403), TuplesKt.to("kimono", 128088), TuplesKt.to("briefs", 129650), TuplesKt.to("bikini", 128089), TuplesKt.to("purse", 128091), TuplesKt.to("handbag", 128092), TuplesKt.to("pouch", 128093), TuplesKt.to("mans_shoe", 128094), TuplesKt.to("flat_shoe", 129407), TuplesKt.to("high_heel", 128096), TuplesKt.to("sandal", 128097), TuplesKt.to("boot", 128098), TuplesKt.to("crown", 128081), TuplesKt.to("billed_cap", 129506), TuplesKt.to("womans_hat", 128082), TuplesKt.to("tophat", 127913), TuplesKt.to("kiss", 128139), TuplesKt.to("lipstick", 128132), TuplesKt.to("ring", 128141), TuplesKt.to("gem", 128142), TuplesKt.to("soccer", 9917), TuplesKt.to("baseball", 9918), TuplesKt.to("softball", 129358), TuplesKt.to("basketball", 127936), TuplesKt.to("volleyball", 127952), TuplesKt.to("football", 127944), TuplesKt.to("8ball", 127921), TuplesKt.to("bowling", 127923), TuplesKt.to("golf", 9971), TuplesKt.to("ice_skate", 9976), TuplesKt.to("canoe", 128758), TuplesKt.to("ski", 127935), TuplesKt.to("sled", 128759), TuplesKt.to("goal_net", 129349), TuplesKt.to("ice_hockey", 127954), TuplesKt.to("lacrosse", 129357), TuplesKt.to("ping_pong", 127955), TuplesKt.to("badminton", 127992), TuplesKt.to("tennis", 127934), TuplesKt.to("kite", 129665), TuplesKt.to("dart", 127919), TuplesKt.to("medal", 127941), TuplesKt.to("trophy", 127942), TuplesKt.to("video_game", 127918), TuplesKt.to("joystick", 128377), TuplesKt.to("game_die", 127922), TuplesKt.to("teddy_bear", 129528), TuplesKt.to("yoyo", 129664), TuplesKt.to("mahjong", 126980), TuplesKt.to("chess_pawn", 9823), TuplesKt.to("spades", 9824), TuplesKt.to("clubs", 9827), TuplesKt.to("hearts", 9829), TuplesKt.to("diamonds", 9830), TuplesKt.to("speaker", 128264), TuplesKt.to("sound", 128265), TuplesKt.to("loud_sound", 128266), TuplesKt.to("mega", 128227), TuplesKt.to("bell", 128276), TuplesKt.to("notes", 127926), TuplesKt.to("microphone", 127908), TuplesKt.to("headphones", 127911), TuplesKt.to("drum", 129345), TuplesKt.to("saxophone", 127927), TuplesKt.to("trumpet", 127930), TuplesKt.to("guitar", 127928), TuplesKt.to("banjo", 129685), TuplesKt.to("violin", 127931), TuplesKt.to("radio", 128251), TuplesKt.to("lock", 128274), TuplesKt.to("unlock", 128275), TuplesKt.to("key", 128273), TuplesKt.to("old_key", 128477), TuplesKt.to("axe", 129683), TuplesKt.to("hammer", 128296), TuplesKt.to("pick", 9935), TuplesKt.to("wrench", 128295), TuplesKt.to("brick", 129521), TuplesKt.to("gear", 9881), TuplesKt.to("oil_drum", 128738), TuplesKt.to("alembic", 9879), TuplesKt.to("test_tube", 129514), TuplesKt.to("petri_dish", 129515), TuplesKt.to("dna", 129516), TuplesKt.to("syringe", 128137), TuplesKt.to("pill", 128138), TuplesKt.to("microscope", 128300), TuplesKt.to("telescope", 128301), TuplesKt.to("scales", 9878), TuplesKt.to("link", 128279), TuplesKt.to("chains", 9939), TuplesKt.to("toolbox", 129520), TuplesKt.to("magnet", 129522), TuplesKt.to("shield", 128737), TuplesKt.to("dagger", 128481), TuplesKt.to("bomb", 128163), TuplesKt.to("gun", 128299), TuplesKt.to("telephone", 9742), TuplesKt.to("pager", 128223), TuplesKt.to("fax", 128224), TuplesKt.to("phone", 128241), TuplesKt.to("calling", 128242), TuplesKt.to("female", 9792), TuplesKt.to("male", 9794), TuplesKt.to("smoking", 128684), TuplesKt.to("coffin", 9904), TuplesKt.to("moai", 128511), TuplesKt.to("battery", 128267), TuplesKt.to("computer", 128187), TuplesKt.to("printer", 128424), TuplesKt.to("keyboard", 9000), TuplesKt.to("trackball", 128434), TuplesKt.to("minidisc", 128189), TuplesKt.to("cd", 128191), TuplesKt.to("dvd", 128192), TuplesKt.to("abacus", 129518), TuplesKt.to("clapper", 127916), TuplesKt.to("satellite", 128225), TuplesKt.to("tv", 128250), TuplesKt.to("camera", 128247), TuplesKt.to("vhs", 128252), TuplesKt.to("mag", 128269), TuplesKt.to("mag_right", 128270), TuplesKt.to("candle", 128367), TuplesKt.to("diya_lamp", 129684), TuplesKt.to("bulb", 128161), TuplesKt.to("flashlight", 128294), TuplesKt.to("book", 128214), TuplesKt.to("green_book", 128215), TuplesKt.to("blue_book", 128216), TuplesKt.to("books", 128218), TuplesKt.to("notebook", 128211), TuplesKt.to("ledger", 128210), TuplesKt.to("scroll", 128220), TuplesKt.to("newspaper", 128240), TuplesKt.to("bookmark", 128278), TuplesKt.to(Constants.ScionAnalytics.PARAM_LABEL, 127991), TuplesKt.to("moneybag", 128176), TuplesKt.to("coin", 129689), TuplesKt.to("yen", 128180), TuplesKt.to("dollar", 128181), TuplesKt.to("euro", 128182), TuplesKt.to("pound", 128183), TuplesKt.to("receipt", 129534), TuplesKt.to("atm", 127975), TuplesKt.to("envelope", 9993), TuplesKt.to("email", 128231), TuplesKt.to("inbox_tray", 128229), TuplesKt.to("package", 128230), TuplesKt.to("mailbox", 128235), TuplesKt.to("postbox", 128238), TuplesKt.to("ballot_box", 128499), TuplesKt.to("pencil2", 9999), TuplesKt.to("black_nib", 10002), TuplesKt.to("pen", 128394), TuplesKt.to("paintbrush", 128396), TuplesKt.to("crayon", 128397), TuplesKt.to("memo", 128221), TuplesKt.to("briefcase", 128188), TuplesKt.to("date", 128197), TuplesKt.to("calendar", 128198), TuplesKt.to("card_index", 128199), TuplesKt.to("bar_chart", 128202), TuplesKt.to("clipboard", 128203), TuplesKt.to("pushpin", 128204), TuplesKt.to("paperclip", 128206), TuplesKt.to("scissors", 9986), TuplesKt.to("hourglass", 8987), TuplesKt.to("watch", 8986), TuplesKt.to(NotificationCompat.CATEGORY_STOPWATCH, 9201), TuplesKt.to("pizza", 127829), TuplesKt.to("hamburger", 127828), TuplesKt.to("fries", 127839), TuplesKt.to("hotdog", 127789), TuplesKt.to("popcorn", 127871), TuplesKt.to("salt", 129474), TuplesKt.to("bacon", 129363), TuplesKt.to("egg", 129370), TuplesKt.to("cooking", 127859), TuplesKt.to("waffle", 129479), TuplesKt.to("pancakes", 129374), TuplesKt.to("butter", 129480), TuplesKt.to("bread", 127838), TuplesKt.to("croissant", 129360), TuplesKt.to("pretzel", 129384), TuplesKt.to("bagel", 129391), TuplesKt.to("sandwich", 129386), TuplesKt.to("taco", 127790), TuplesKt.to("burrito", 127791), TuplesKt.to("dumpling", 129375), TuplesKt.to("bento", 127857), TuplesKt.to("rice_ball", 127833), TuplesKt.to("rice", 127834), TuplesKt.to("curry", 127835), TuplesKt.to("ramen", 127836), TuplesKt.to("oyster", 129450), TuplesKt.to("sushi", 127843), TuplesKt.to("fish_cake", 127845), TuplesKt.to("moon_cake", 129390), TuplesKt.to("oden", 127842), TuplesKt.to("falafel", 129478), TuplesKt.to("stew", 127858), TuplesKt.to("spaghetti", 127837), TuplesKt.to("pie", 129383), TuplesKt.to("icecream", 127846), TuplesKt.to("shaved_ice", 127847), TuplesKt.to("ice_cream", 127848), TuplesKt.to("doughnut", 127849), TuplesKt.to("cookie", 127850), TuplesKt.to("birthday", 127874), TuplesKt.to("cake", 127856), TuplesKt.to("cupcake", 129473), TuplesKt.to("candy", 127852), TuplesKt.to("lollipop", 127853), TuplesKt.to("dango", 127841), TuplesKt.to("custard", 127854), TuplesKt.to("honey_pot", 127855), TuplesKt.to("coffee", 9749), TuplesKt.to("tea", 127861), TuplesKt.to("mate", 129481), TuplesKt.to("sake", 127862), TuplesKt.to("champagne", 127870), TuplesKt.to("wine_glass", 127863), TuplesKt.to("cocktail", 127864), TuplesKt.to("beer", 127866), TuplesKt.to("beers", 127867), TuplesKt.to("ice", 129482), TuplesKt.to("chopsticks", 129378), TuplesKt.to("spoon", 129348), TuplesKt.to("amphora", 127994), TuplesKt.to("kiwi", 129373), TuplesKt.to("coconut", 129381), TuplesKt.to("grapes", 127815), TuplesKt.to("melon", 127816), TuplesKt.to("watermelon", 127817), TuplesKt.to("tangerine", 127818), TuplesKt.to("lemon", 127819), TuplesKt.to("banana", 127820), TuplesKt.to("pineapple", 127821), TuplesKt.to("mango", 129389), TuplesKt.to("apple", 127822), TuplesKt.to("pear", 127824), TuplesKt.to("peach", 127825), TuplesKt.to("cherries", 127826), TuplesKt.to("strawberry", 127827), TuplesKt.to("tomato", 127813), TuplesKt.to("eggplant", 127814), TuplesKt.to("corn", 127805), TuplesKt.to("pepper", 127798), TuplesKt.to("mushroom", 127812), TuplesKt.to("avocado", 129361), TuplesKt.to("cucumber", 129362), TuplesKt.to("broccoli", 129382), TuplesKt.to("potato", 129364), TuplesKt.to("garlic", 129476), TuplesKt.to("onion", 129477), TuplesKt.to("carrot", 129365), TuplesKt.to("chestnut", 127792), TuplesKt.to("peanuts", 129372), TuplesKt.to("bouquet", 128144), TuplesKt.to("rosette", 127989), TuplesKt.to("rose", 127801), TuplesKt.to("hibiscus", 127802), TuplesKt.to("sunflower", 127803), TuplesKt.to("blossom", 127804), TuplesKt.to("tulip", 127799), TuplesKt.to("shamrock", 9752), TuplesKt.to("seedling", 127793), TuplesKt.to("palm_tree", 127796), TuplesKt.to("cactus", 127797), TuplesKt.to("herb", 127807), TuplesKt.to("maple_leaf", 127809), TuplesKt.to("leaves", 127811), TuplesKt.to("automobile", 128663), TuplesKt.to("police_car", 128659), TuplesKt.to("taxi", 128661), TuplesKt.to("blue_car", 128665), TuplesKt.to("bus", 128652), TuplesKt.to("minibus", 128656), TuplesKt.to("trolleybus", 128654), TuplesKt.to("ambulance", 128657), TuplesKt.to("truck", 128666), TuplesKt.to("tractor", 128668), TuplesKt.to("skateboard", 128761), TuplesKt.to("bike", 128690), TuplesKt.to("motorcycle", 127949), TuplesKt.to("racing_car", 127950), TuplesKt.to("light_rail", 128648), TuplesKt.to("monorail", 128669), TuplesKt.to("train", 128651), TuplesKt.to("train2", 128646), TuplesKt.to("station", 128649), TuplesKt.to("tram", 128650), TuplesKt.to("metro", 128647), TuplesKt.to("parachute", 129666), TuplesKt.to("airplane", 9992), TuplesKt.to("seat", 128186), TuplesKt.to("helicopter", 128641), TuplesKt.to("rocket", 128640), TuplesKt.to("sailboat", 9973), TuplesKt.to("speedboat", 128676), TuplesKt.to("motor_boat", 128741), TuplesKt.to("ferry", 9972), TuplesKt.to("ship", 128674), TuplesKt.to("anchor", 9875), TuplesKt.to("busstop", 128655), TuplesKt.to("fuelpump", 9981), TuplesKt.to("flag_white", 127987), TuplesKt.to("flag_black", 127988), TuplesKt.to("red_flag", 128681), TuplesKt.to("milky_way", 127756), TuplesKt.to("earth_asia", 127759), TuplesKt.to("world_map", 128506), TuplesKt.to("compass", 129517), TuplesKt.to("mountain", 9968), TuplesKt.to("volcano", 127755), TuplesKt.to("fuji", 128507), TuplesKt.to("camping", 127957), TuplesKt.to("motorway", 128739), TuplesKt.to("desert", 127964), TuplesKt.to("stadium", 127967), TuplesKt.to("houses", 127960), TuplesKt.to("cityscape", 127961), TuplesKt.to("house", 127968), TuplesKt.to("church", 9962), TuplesKt.to("kaaba", 128331), TuplesKt.to("mosque", 128332), TuplesKt.to("synagogue", 128333), TuplesKt.to("office", 127970), TuplesKt.to("hospital", 127973), TuplesKt.to("bank", 127974), TuplesKt.to("hotel", 127976), TuplesKt.to("school", 127979), TuplesKt.to("factory", 127981), TuplesKt.to("wedding", 128146), TuplesKt.to("japan", 128510), TuplesKt.to("fountain", 9970), TuplesKt.to("tent", 9978), TuplesKt.to("foggy", 127745), TuplesKt.to("sunrise", 127749), TuplesKt.to("hotsprings", 9832), TuplesKt.to("barber", 128136), TuplesKt.to("luggage", 129523), TuplesKt.to("chair", 129681), TuplesKt.to("door", 128682), TuplesKt.to("bed", 128719), TuplesKt.to("toilet", 128701), TuplesKt.to("shower", 128703), TuplesKt.to("bathtub", 128705), TuplesKt.to("soap", 129532), TuplesKt.to("sponge", 129533), TuplesKt.to("razor", 129682), TuplesKt.to("safety_pin", 129527), TuplesKt.to("broom", 129529), TuplesKt.to("basket", 129530), TuplesKt.to("cloud", Integer.valueOf((int) C.TEXTURE_MIN_FILTER_LINEAR)), TuplesKt.to("tornado", 127786), TuplesKt.to("fog", 127787), TuplesKt.to("new_moon", 127761), TuplesKt.to("full_moon", 127765), TuplesKt.to("moon_face", 127770), TuplesKt.to(LocalePreferences.FirstDayOfWeek.SUNDAY, 9728), TuplesKt.to("sun_face", 127774), TuplesKt.to("star2", 127775), TuplesKt.to("stars", 127776), TuplesKt.to("comet", 9732), TuplesKt.to("cyclone", 127744), TuplesKt.to("rainbow", 127752), TuplesKt.to("umbrella", 9748), TuplesKt.to("zap", 9889), TuplesKt.to("snowflake", 10052), TuplesKt.to("snowman", 9924), TuplesKt.to("fire", 128293), TuplesKt.to("droplet", 128167), TuplesKt.to("ocean", 127754), TuplesKt.to("two_hearts", 128149), TuplesKt.to("heartbeat", 128147), TuplesKt.to("heartpulse", 128151), TuplesKt.to("cupid", 128152), TuplesKt.to("gift_heart", 128157), TuplesKt.to("anger", 128162), TuplesKt.to("boom", 128165), TuplesKt.to("afk", 128164), TuplesKt.to("dash", 128168), TuplesKt.to("hole", 128371), TuplesKt.to("peace", 9774), TuplesKt.to("cross", 10013), TuplesKt.to("om", 128329), TuplesKt.to("menorah", 128334), TuplesKt.to("yin_yang", 9775), TuplesKt.to("ophiuchus", 9934), TuplesKt.to("aries", 9800), TuplesKt.to("taurus", 9801), TuplesKt.to("gemini", 9802), TuplesKt.to("cancer", 9803), TuplesKt.to("leo", 9804), TuplesKt.to("virgo", 9805), TuplesKt.to("libra", 9806), TuplesKt.to("scorpius", 9807), TuplesKt.to("capricorn", 9809), TuplesKt.to("aquarius", 9810), TuplesKt.to("pisces", 9811), TuplesKt.to("id", 127380), TuplesKt.to("infinity", 9854), TuplesKt.to("atom", 9883), TuplesKt.to("vs", 127386), TuplesKt.to("cl", 127377), TuplesKt.to("sos", 127384), TuplesKt.to("no_entry", 9940), TuplesKt.to("name_badge", 128219), TuplesKt.to("x", 10060), TuplesKt.to("mute", 128263), TuplesKt.to("no_bell", 128277), TuplesKt.to("trident", 128305), TuplesKt.to("biohazard", 9763), TuplesKt.to("warning", 9888), TuplesKt.to("beginner", 128304), TuplesKt.to("recycle", 9851), TuplesKt.to("chart", 128185), TuplesKt.to("true", 9989), TuplesKt.to("customs", 128707), TuplesKt.to("lua", 9855), TuplesKt.to("wc", 128702), TuplesKt.to("mens", 128697), TuplesKt.to("restroom", 128699), TuplesKt.to("ng", 130070), TuplesKt.to("ok2", 127383), TuplesKt.to("up2", 127385), TuplesKt.to("cool", 127378), TuplesKt.to("new", 127381), TuplesKt.to("free", 127379), TuplesKt.to("play_pause", 9199), TuplesKt.to("track_next", 9197), TuplesKt.to("rewind", 9194), TuplesKt.to("repeat", 128257), TuplesKt.to("repeat_one", 128258), TuplesKt.to("cinema", 127910), TuplesKt.to("abc", 128292), TuplesKt.to("abcd", 128289), TuplesKt.to("symbols", 128291), TuplesKt.to(DebugKt.DEBUG_PROPERTY_VALUE_ON, 128283), TuplesKt.to("top", 128285), TuplesKt.to("soon", 128284), TuplesKt.to(TtmlNode.END, 128282), TuplesKt.to("back", 128281), TuplesKt.to("cleo", 129702), TuplesKt.to("redcode", 130048), TuplesKt.to("rc", 130049), TuplesKt.to("arz", 130056), TuplesKt.to("az", 130057), TuplesKt.to("ag", 130058), TuplesKt.to("rodina", 130059), TuplesKt.to("buy", 130074), TuplesKt.to("sell", 130075), TuplesKt.to("rent", 130076), TuplesKt.to("trade", 130077), TuplesKt.to("vc", 62052), TuplesKt.to("k", 62053), TuplesKt.to("kk", 62054), TuplesKt.to(CmcdData.OBJECT_TYPE_MANIFEST, 62055), TuplesKt.to("kv", 62056), TuplesKt.to("kkv", 62057), TuplesKt.to("mv", 62058), TuplesKt.to("la", 127462), TuplesKt.to("lb", 127463), TuplesKt.to("lc", 127464), TuplesKt.to("ld", 127465), TuplesKt.to("le", 127466), TuplesKt.to("lf", 127467), TuplesKt.to("lg", 127468), TuplesKt.to("lh", 127469), TuplesKt.to("li", 127470), TuplesKt.to("lj", 127471), TuplesKt.to("lk", 127472), TuplesKt.to("ll", 127473), TuplesKt.to("lm", 127474), TuplesKt.to("ln", 127475), TuplesKt.to("lo", 127476), TuplesKt.to("lp", 127477), TuplesKt.to("lq", 127478), TuplesKt.to("lr", 127479), TuplesKt.to("ls", 127480), TuplesKt.to("lt", 127481), TuplesKt.to("lu", 127482), TuplesKt.to("lv", 127483), TuplesKt.to("lw", 127484), TuplesKt.to("lx", 127485), TuplesKt.to("ly", 127486), TuplesKt.to("lz", 127487), TuplesKt.to("na", 130064), TuplesKt.to("nb", 130065), TuplesKt.to("nc", 130066), TuplesKt.to("nd", 130067), TuplesKt.to("ne", 130068), TuplesKt.to("nf", 130069), TuplesKt.to("nh", 130071), TuplesKt.to("ni", 130072), TuplesKt.to("nj", 130073));

    public final boolean isCustomCp(int i) {
        if (61952 > i || i >= 62059) {
            return 130048 <= i && i < 130078;
        }
        return true;
    }

    public final boolean validCp(int i) {
        if (8192 > i || i >= 8470) {
            if (8471 > i || i >= 10241) {
                if ((61952 > i || i >= 62042) && i != 62043) {
                    if (62208 > i || i >= 62274) {
                        return 65536 <= i && i < 131072;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private ChatEmoji() {
    }

    public final Map<String, Integer> getNamedTags() {
        return namedTags;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
        if (ru.mrlargha.commonui.utils.emoji.ChatEmoji.INSTANCE.validCp(r3) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String parseEmojiInText(CharSequence text) {
        int indexOf;
        int i;
        int indexOf2;
        int i2;
        Integer num;
        int length;
        Intrinsics.checkNotNullParameter(text, "text");
        StringBuilder sb = new StringBuilder(text);
        int i3 = 0;
        while (i3 < sb.length() && (indexOf = sb.indexOf(StringUtils.PROCESS_POSTFIX_DELIMITER, i3)) != -1 && (indexOf2 = sb.indexOf(StringUtils.PROCESS_POSTFIX_DELIMITER, (i = indexOf + 1))) != -1) {
            int i4 = indexOf2 - indexOf;
            if (i4 < 2) {
                i3 = i;
            } else {
                if (i4 <= 12) {
                    String substring = sb.substring(i, indexOf2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    String lowerCase = substring.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (lowerCase.charAt(0) == 'u' && 3 <= (length = lowerCase.length()) && length < 7) {
                        String substring2 = lowerCase.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        Integer intOrNull = StringsKt.toIntOrNull(substring2, 16);
                        if (intOrNull != null) {
                            i2 = intOrNull.intValue();
                        }
                    }
                    i2 = 0;
                    if (i2 == 0 && (num = namedTags.get(lowerCase)) != null) {
                        i2 = num.intValue();
                    }
                    if (i2 != 0) {
                        char[] chars = Character.toChars(i2);
                        Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
                        String str = new String(chars);
                        sb.replace(indexOf, indexOf2 + 1, str);
                        i3 = indexOf + str.length();
                    }
                }
                i3 = indexOf2;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (iconFont != null) {
            return;
        }
        iconFont = ResourcesCompat.getFont(context, R.font.icons);
    }

    public static /* synthetic */ SpannableString applyIconFont$default(ChatEmoji chatEmoji, SpannableString spannableString, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        return chatEmoji.applyIconFont(spannableString, f);
    }

    public final SpannableString applyIconFont(SpannableString spannable, float f) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Typeface typeface = iconFont;
        if (typeface != null) {
            String spannableString = spannable.toString();
            Intrinsics.checkNotNullExpressionValue(spannableString, "toString(...)");
            int i = 0;
            while (i < spannableString.length()) {
                int codePointAt = Character.codePointAt(spannableString, i);
                int charCount = Character.charCount(codePointAt);
                if (isCustomCp(codePointAt)) {
                    spannable.setSpan(new IconTypefaceSpan(typeface, f, -0.12f), i, i + charCount, 33);
                }
                i += charCount;
            }
        }
        return spannable;
    }

    /* compiled from: ChatEmoji.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/utils/emoji/ChatEmoji$IconTypefaceSpan;", "Landroid/text/style/MetricAffectingSpan;", "typeface", "Landroid/graphics/Typeface;", "scale", "", "shiftRatio", "<init>", "(Landroid/graphics/Typeface;FF)V", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "updateMeasureState", "apply", "paint", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class IconTypefaceSpan extends MetricAffectingSpan {
        private final float scale;
        private final float shiftRatio;
        private final Typeface typeface;

        public IconTypefaceSpan(Typeface typeface, float f, float f2) {
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            this.typeface = typeface;
            this.scale = f;
            this.shiftRatio = f2;
        }

        public /* synthetic */ IconTypefaceSpan(Typeface typeface, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(typeface, (i & 2) != 0 ? 1.0f : f, (i & 4) != 0 ? 0.0f : f2);
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint tp) {
            Intrinsics.checkNotNullParameter(tp, "tp");
            apply(tp);
        }

        @Override // android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint tp) {
            Intrinsics.checkNotNullParameter(tp, "tp");
            apply(tp);
        }

        private final void apply(TextPaint textPaint) {
            textPaint.setTypeface(this.typeface);
            textPaint.setTextSize(textPaint.getTextSize() * this.scale);
            textPaint.baselineShift += (int) (textPaint.getTextSize() * this.shiftRatio);
        }
    }

    public static /* synthetic */ SpannableString toSpannable$default(ChatEmoji chatEmoji, CharSequence charSequence, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return chatEmoji.toSpannable(charSequence, f);
    }

    public final SpannableString toSpannable(CharSequence charSequence, float f) {
        if (charSequence == null) {
            return new SpannableString("");
        }
        return applyIconFont(tagsColor(parseEmojiInText(charSequence)), f);
    }

    public final SpannableString tagsColor(CharSequence charSequence) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            Regex regex = new Regex("\\{[0-9A-z]*\\}");
            MatchResult find = regex.find(charSequence, 0);
            i = 0;
            i2 = -1;
            i3 = -1;
            while (find != null) {
                try {
                    i4 = Color.parseColor('#' + StringsKt.substring(find.getValue(), new IntRange(1, 6)));
                } catch (NumberFormatException unused) {
                    i4 = -1;
                }
                if (i2 != -1) {
                    int i5 = i2 + 1;
                    spannableStringBuilder.append(charSequence.subSequence(i5, find.getRange().getFirst()));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i5 - i, find.getRange().getFirst() - i, 34);
                } else {
                    spannableStringBuilder.append((CharSequence) charSequence.subSequence(0, find.getRange().getFirst()).toString());
                }
                i += 8;
                i2 = find.getRange().getLast();
                find = regex.find(charSequence, find.getRange().getLast());
                i3 = i4;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("DialogFactory", "last index error");
        }
        if (i2 != -1) {
            int i6 = i2 + 1;
            spannableStringBuilder.append(charSequence.subSequence(i6, StringsKt.getLastIndex(charSequence) + 1));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i6 - i, (StringsKt.getLastIndex(charSequence) + 1) - i, 34);
            SpannableString valueOf = SpannableString.valueOf(spannableStringBuilder);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf;
        }
        return new SpannableString(charSequence);
    }
}
