package com.example.apparelmarket.models;
import com.example.apparelmarket.R;

import java.util.ArrayList;

public class ApparelProvider {

    static int[] itemViews = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    static String[] itemIDs = {
            "001", "002", "003", "004", "005", "006", "007", "008", "009", "010",
            "011", "012", "013", "014", "015", "016", "017", "018", "019", "020",
            "021", "022", "023", "024", "025", "026", "027", "028", "029", "030"
    };

    static String[] itemCategories = {
            "Chinos", "Chinos", "Chinos", "Chinos", "Chinos", "Chinos", "Chinos", "Chinos", "Chinos", "Chinos",
            "Shirt", "Shirt", "Shirt", "Shirt", "Shirt", "Shirt", "Shirt", "Shirt", "Shirt", "Shirt",
            "Shoes", "Shoes", "Shoes", "Shoes", "Shoes", "Shoes", "Shoes", "Shoes", "Shoes", "Shoes"
    };

    static String[] itemPrices = {
            "$69.99", "$49.99", "$199.99", "$12.99", "$48.42", "$39.23", "$93.12", "$13.35", "$35.13", "$95.23",
            "$36.63", "$24.46", "$26.37", "$63.48", "$62.41", "$67.42", "$46.13", "$24.46", "$31.53", "$24.13",
            "$24.13", "$514.43", "$14.53", "$6.24", "$537.24", "$24.12", "$356.24", "$42.13", "$467.13", "$31.24"
    };

    static String[] itemNames = {
            "boohooMAN winter tartan trouser", "New Look slim chinos", "Ted Baker slim fit stretch trousers", "Only & Sons drawstring jersey trousers", "Burton Menswear skinny trousers",
            "Celio slim trousers in cream", "Weekday Tucker Checked Trousers in Grey", "Only & Sons stretch smart trouser", "ASOS DESIGN 2 pack skinny chinos", "Nike Pro Training tights in black",

            "PS Paul Smith patchwork pocket shirt in khaki", "Armani Exchange all over logo long sleeve shirt", "AllSaints revere collar shirt with spliced tiger print", "Polo Ralph Lauren short sleeve stripe oxford shirt", "Tommy Hilfiger oxford shirt",
            "Celio shirt in beige linen", "ASOS DESIGN relaxed fit linen shirt", "ASOS DESIGN stretch skinny fit shirt", "ASOS DESIGN regular fit sheer shirt", "Pull&Bear short sleeve shirt with aztec print",

            "Bronx seventy street trainers in graffiti", "Nike Running Renew Run trainers", "Fred Perry Deuce leather trainers", "Vans Anaheim Old Skool 36 DX trainer", "Converse Chuck Taylor All Star Ox Tie Dye trainer",
            "Dr Martens jadon platform boots", "Nike Running Joyride Dual Run trainers", "Burton Menswear cleated leather chelsea boot", "ASOS DESIGN slip on mule espadrilles in navy suede", "Nike Air Max 2090 trainers"
    };


    static String[] itemDetails = {
    "An alternative to your denim. Tartan check design. Belt loops.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Soft woven fabric. It's got a little stretch.",
    "Chinos by New Look. Give your jeans a day off. Regular rise. Belt loops.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Soft, stretch twill. Semi-structured fabric with a parallel-rib pattern.",
    "Trousers by Ted Baker. A little bit smart. Zip fly with button fastening. Side pockets.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Soft, stretch twill. Semi-structured fabric with a parallel-rib pattern.",
    "Trousers by Only & Sons. For your everyday thing. Regular rise. Drawstring waist.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Soft fabric. Slightly stretchy.",
    "Chinos by Burton Menswear London. A little bit smart. Checked design. Belt loops.\n" +
            "Model's height: 188cm/6'2\".\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Smooth woven fabric. It's got a little stretch.",
    "Trousers by Celio. A little bit smart. Regular rise. Concealed fly with button fastening.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Textured woven fabric. It's got a little stretch.",
    "Trousers by Weekday. Part of our responsible edit. Belt loops. Zip fly with button fastening.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Lightweight woven fabric. Made from organic cotton.",
    "Trousers by Only & Sons. Coming soon to your Saved Items. Pinstripe design. Zip fly with button fastening.\n" +
            "Model's height: 6'2”/188 cm.\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Lightweight woven fabric. The kind that stretches.",
    "Chinos multipack by ASOS DESIGN. Part of our responsible edit. Pack of two pairs. Belt loops.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Soft woven fabric. It's got a little stretch.",
    "Tights by Nike. Elasticated waistband. Nike Pro branding.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: W 32\" L 32\".\n" +
            "Tight, stretchy Nike Pro fabric. Uses Nike Dri-FIT technology.",
    "Shirt by PS Paul Smith. Casual, meet smart. Long sleeves. Button placket.\n" +
            "Model's height: 183cm/6'0\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Lightweight cotton. Soft, strong and breathable.",
    "Shirt by Armani Exchange. For your everyday thing. All-over logo print. Spread collar. Button placket.\n" +
            "Model's height: 183cm/6'0\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Crisp woven cotton. Its got a little stretch.",
    "Shirt by AllSaints. For your daytime thing. Revere collar. Button placket.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Lightweight viscose. Soft and drapey.",
    "Shirt by Polo Ralph Lauren. Part of our responsible edit. Striped design. Button-down collar.\n" +
            "Model's height: 187.5cm/6'2\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Lightweight cotton. Polo Ralph Lauren partners with the Better Cotton Initiative to improve cotton farming globally.",
    "Oxford shirt by Tommy Hilfiger. Breathable cotton. Button-down collar. Embroidered logo.\n" +
            "Model's height: 6'2”/188 cm.\n" +
            "Model is wearing: Size Medium.\n" +
            "Main: 98% Cotton, 2% Elastane.",
    "Shirt by Celio. Spread collar. Button placket. Chest pocket.\n" +
            "Model's height: 183cm/6'2.5\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Lightweight linen. Strong, breathable fabric.",
    "Shirt by ASOS DESIGN. Revere collar. Short sleeves. Plain design.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Linen-rich fabric. It's strong and breathable.",
    "Shirt by ASOS DESIGN. Part of our responsible edit. Spread collar. Button placket.\n" +
            "Model's height: 178cm/5'10\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Lightweight cotton. Soft, strong and breathable.",
    "Shirt by ASOS DESIGN. Let your outfit do the talking. Animal print. Notch lapels/\n" +
            "Model's height: 187.5cm/6'2\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Lightweight, woven fabric. For those see-through vibes.",
    "Shirt by Pull&Bear. Not every day's a T-shirt day. All-over Aztec print. Revere collar.\n" +
            "Model's height: 185.5cm/6'1\".\n" +
            "Model is wearing: Size Medium.\n" +
            "Lightweight woven fabric. Soft and drapey.",
    "Trainers by Bronx. Unboxing potential: considerable. Graffiti print. Lace-up fastening.\n" +
            "Matte leather upper. Leather lining.",
    "Trainers by Nike. Elevate your run. Lace-up fastening\n" +
            "Padded tongue and cuffs for comfort.\n" +
            "Breathable mesh upper. Keeps them fresher for longer.",
    "Trainers by Fred Perry. Unboxing potential: considerable. Low-profile design. Lace-up fastening.\n" +
            "Smooth leather upper. Matte finish.",
    "Trainers by Vans. Unboxing potential: considerable. Colour-block design. Lace-up fastening.\n" +
            "Canvas upper. Durable, plain-woven fabric.",
    "Trainers by Converse. Unboxing potential: considerable . Tie-dye finish. Lace-up design.\n" +
            "Lightly textured canvas upper. Durable, plain-woven fabric.",
    "Boots by Dr Martens. Zip and lace-up fastening. Round toe.\n" +
            "Smooth leather upper. Glossy, patent finish.",
    "Trainers by Nike. Elevate your run. Lace-up fastening. Nike Swoosh logo.\n" +
            "Breathable mesh upper. Smooth overlays.",
    "Boots by Burton Menswear London. Your rain-or-shine shoes. Elasticated inserts. Pull tabs.\n" +
            "Leather and suede upper. Matte finish.",
    "Espadrilles by ASOS DESIGN. Who needs the back of a shoe anyway? Slip-on style. Gold-tone snaffle detail.\n" +
            "Soft suede upper. Fuzzy, velvety finish.",
    "Trainers by Nike. Lace-up design. Pull tabs for easy on/off.\n" +
            "Knitted upper. Comfy, sock-like fit."
    };

    static int[] itemImageAddrs = {
            R.drawable.chinos_1_1, R.drawable.chinos_1_2, R.drawable.chinos_1_3, R.drawable.chinos_2_1, R.drawable.chinos_2_2, R.drawable.chinos_2_3, R.drawable.chinos_3_1, R.drawable.chinos_3_2, R.drawable.chinos_3_3, R.drawable.chinos_4_1, R.drawable.chinos_4_2, R.drawable.chinos_4_3, R.drawable.chinos_5_1, R.drawable.chinos_5_2, R.drawable.chinos_5_3,
            R.drawable.chinos_6_1, R.drawable.chinos_6_2, R.drawable.chinos_6_3, R.drawable.chinos_7_1, R.drawable.chinos_7_2, R.drawable.chinos_7_3, R.drawable.chinos_8_1, R.drawable.chinos_8_2, R.drawable.chinos_8_3, R.drawable.chinos_9_1, R.drawable.chinos_9_2, R.drawable.chinos_9_3, R.drawable.chinos_10_1, R.drawable.chinos_10_2, R.drawable.chinos_10_3,

            R.drawable.shirt_1_1, R.drawable.shirt_1_2, R.drawable.shirt_1_3, R.drawable.shirt_2_1, R.drawable.shirt_2_2, R.drawable.shirt_2_3, R.drawable.shirt_3_1, R.drawable.shirt_3_2, R.drawable.shirt_3_3, R.drawable.shirt_4_1, R.drawable.shirt_4_2, R.drawable.shirt_4_3, R.drawable.shirt_5_1, R.drawable.shirt_5_2, R.drawable.shirt_5_3,
            R.drawable.shirt_6_1, R.drawable.shirt_6_2, R.drawable.shirt_6_3, R.drawable.shirt_7_1, R.drawable.shirt_7_2, R.drawable.shirt_7_3, R.drawable.shirt_8_1, R.drawable.shirt_8_2, R.drawable.shirt_8_3, R.drawable.shirt_9_1, R.drawable.shirt_9_2, R.drawable.shirt_9_3, R.drawable.shirt_10_1, R.drawable.shirt_10_2, R.drawable.shirt_10_3,

            R.drawable.shoes_1_1, R.drawable.shoes_1_2, R.drawable.shoes_1_3, R.drawable.shoes_2_1, R.drawable.shoes_2_2, R.drawable.shoes_2_3, R.drawable.shoes_3_1, R.drawable.shoes_3_2, R.drawable.shoes_3_3, R.drawable.shoes_4_1, R.drawable.shoes_4_2, R.drawable.shoes_4_3, R.drawable.shoes_5_1, R.drawable.shoes_5_2, R.drawable.shoes_5_3,
            R.drawable.shoes_6_1, R.drawable.shoes_6_2, R.drawable.shoes_6_3, R.drawable.shoes_7_1, R.drawable.shoes_7_2, R.drawable.shoes_7_3, R.drawable.shoes_8_1, R.drawable.shoes_8_2, R.drawable.shoes_8_3, R.drawable.shoes_9_1, R.drawable.shoes_9_2, R.drawable.shoes_9_3, R.drawable.shoes_10_1, R.drawable.shoes_10_2, R.drawable.shoes_10_3
    };

    // Increments the number of views for a given item - Simulated.
    public static void incrementItemViews(int position) {
        itemViews[position] = itemViews[position] + 1;
    }

    // Generates all the Apparel Item data and returns it as an array.
    public static ArrayList<ApparelItem> generateData() {
        ArrayList<ApparelItem>  apparelItemslist = new ArrayList<ApparelItem>();

        for (int i = 0; i < 30; i++) {
            String idIN = itemIDs[i];
            String itemCategoryIN = itemCategories[i];
            String itemPriceIN = itemPrices[i];
            String itemNameIN = itemNames[i];
            String itemDetailIN = itemDetails[i];
            int itemImageIN[] = new int[3];
            int itemViewIN = itemViews[i];

            // Adds the appropriate images for each item.
            if(i == 0) {
                itemImageIN[0] = itemImageAddrs[i];
                itemImageIN[1] = itemImageAddrs[i+1];
                itemImageIN[2] = itemImageAddrs[i+2];
            } else {
                itemImageIN[0] = itemImageAddrs[3*i];
                itemImageIN[1] = itemImageAddrs[3*i+1];
                itemImageIN[2] = itemImageAddrs[3*i+2];
            }

            ApparelItem ApparelItemIN = new ApparelItem(idIN, itemCategoryIN, itemPriceIN, itemNameIN, itemDetailIN, itemImageIN, itemViewIN);
            apparelItemslist.add(ApparelItemIN);
        }
        return apparelItemslist;
    }

}
