package edu.wccnet.recipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    String[] recipeNameArr = {
            "Caesar Salad with Crispy Chicken",
            "Cottage Pie",
            "Creamy Pesto Chicken with Roasted Tomatoes",
            "Roast Chicken Soup",
            "Chocolate Mousse"};

    int[] recipeImgArr = {
            R.drawable.r1,
            R.drawable.r2,
            R.drawable.r3,
            R.drawable.r4,
            R.drawable.r5
    };

    String[] recipeIngredientsArr = {
            "125ml light mayonnaise juice 1 lemon 1 tbsp Worcestershire sauce 50g Parmesan , grated, plus extra to serve (optional) 1 garlic clove, crushed 50g croûton 1 large Cos lettuce or 4 Little Gem, ripped into pieces.",
            "3 tbsp olive oil 1¼kg beef mince 2 onions , finely chopped 3 carrots , chopped 3 celery sticks, chopped 2 garlic clove, finely chopped 3 tbsp plain flour 1 tbsp tomato purée large glass red wine (optional) 850ml beef stock 4 tbsp Worcestershire sauce few thyme sprigs 2 bay leaves For the mash 1.8kg potatoes , chopped 225ml milk 25g butter 200g strong cheddar , grated freshly grated nutmeg.",
            "4 boneless, skinless chicken breast 3 tbsp Homemade pesto (see the recipe in tip section below) 85g mascarpone 4 tbsp olive oil 100g breadcrumb, preferably from day-old bread 175g baby tomatoes , on the vine handful pine nuts handful basil leaves.",
            "1 tbsp olive oil 2 onion , chopped 3 medium carrot , chopped 1 tbsp thyme leaves, roughly chopped 1.4l chicken stock 300g leftover roast chicken , shredded and skin removed 200g frozen pea 3 tbsp Greek yogurt 1 garlic clove, crushed squeeze lemon juice.",
            "85g dark chocolate, 70% (I used Green & Black's) 1 tbsp cocoa powder, plus extra for dusting ½ tsp coffee granules ½ tsp vanilla extract 2 egg whites 1 tbsp golden caster sugar 50g full-fat Greek yogurt handful raspberries, to decorate."
    };

    String[] recipePreparationArr = {
            "In a large bowl, mix the mayonnaise, lemon juice, Worcestershire sauce, grated Parmesan and garlic, then season. When ready to eat, add the chicken slices, croutons and lettuce. Mix well and sprinkle with extra Parmesan, if you like.",
            "1. Heat 1 tbsp oil in a large saucepan and fry the mince until browned – you may need to do this in batches. Set aside as it browns. Put the rest of the oil into the pan, add the vegetables and cook on a gentle heat until soft, about 20 mins. Add the garlic, flour and tomato purée, increase the heat and cook for a few mins, then return the beef to the pan. Pour over the wine, if using, and boil to reduce it slightly before adding the stock, Worcestershire sauce and herbs. Bring to a simmer and cook, uncovered, for 45 mins. By this time the gravy should be thick and coating the meat. Check after about 30 mins – if a lot of liquid remains, increase the heat slightly to reduce the gravy a little. Season well, then discard the bay leaves and thyme stalks.\n\n2. Meanwhile, make the mash. In a large saucepan, cover the potatoes in salted cold water, bring to the boil and simmer until tender. Drain well, then allow to steam-dry for a few mins. Mash well with the milk, butter, and three-quarters of the cheese, then season with the nutmeg and some salt and pepper.\n\n3. Spoon meat into 2 ovenproof dishes. Pipe or spoon on the mash to cover. Sprinkle on the remaining cheese. If eating straight away, heat oven to 220C/200C fan/gas 7 and cook for 25-30 mins, or until the topping is golden. Or follow the steps (below) to freeze.",
            "1. Heat oven to 200C/fan 180C/gas 6. Use a small sharp knife to make a slit along the side of each chicken breast to form a pocket. Mix together the pesto and mascarpone, then carefully spoon a quarter of the mixture into each chicken breast and smooth over the opening to seal.\n\n2. Brush a little oil, about 1 tsp, all over each chicken breast and season well. Tip the breadcrumbs onto a large plate and season. Place each breast on the plate and press all over with the breadcrumbs. Place in a lightly oiled shallow baking dish along with the tomatoes (kept together on the vine in a couple of bunches). Drizzle over the remaining oil.\n\n3. Cook in the oven for 20-25 mins until the chicken starts to turn golden and is cooked through. Scatter over the pine nuts and cook for 2 mins more. Sprinkle with basil leaves and serve with new potatoes or crusty bread.",
            "1. Heat oil in a large heavy-based pan. Add onions, carrots and thyme, then gently fry for 15 mins. Stir in stock, bring to a boil, cover, then simmer for 10 mins.\n\n2. Add the chicken, remove half the mixture, then purée with a stick blender. Tip back into the pan with the rest of the soup, peas and seasoning, then simmer for 5 mins until hot through.\n\n3. Mix the yogurt, garlic and lemon juice, swirl into the soup in bowls, then serve.",
            "1. Chop the chocolate very finely and put it into a large bowl that will fit over a pan of simmering water. Mix the cocoa, coffee and vanilla with 2 tbsp cold water, and pour over the chocolate. Place the bowl over the gently simmering water, give it all a stir, then remove from the heat. Leave with the bowl of chocolate still over the water, stirring occasionally to check when melted.\n\n2. Stir the melted chocolate, it will be quite thick. Stir in 2 tbsp boiling water and the chocolate will immediately thin down and become silky smooth. Leave to cool slightly.\n\n3. Whisk the egg whites to fairly soft peaks, then whisk in the sugar until thick and glossy. Beat the yogurt into the cooled chocolate. Fold about one-third of the egg whites into the chocolate mix using a large metal spoon, then very gently fold in the rest of the whites until they are evenly mixed in – being careful not to over-mix or you will lose the volume of the mousse. Spoon into 4 small cups or (125-150ml) ramekins and chill for a couple of hours, or overnight.\n\n4. Place each mousse on a saucer or small plate. Top with a few raspberries, then dust with a little cocoa powder. Will keep for up to 2 days in the fridge",
    };

    TextView recipeNameTV;
    ImageView recipeImg;
    TextView recipeIngredientTV;
    ScrollView scrollView;
    Spinner mySpinner;
    ArrayAdapter<CharSequence> myAdapter;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter<CharSequence> adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recipeNameTV = findViewById(R.id.rName);
        recipeImg = findViewById(R.id.rImg);
        recipeIngredientTV = findViewById(R.id.rIng);
        scrollView = findViewById(R.id.scrollV);
        mySpinner = findViewById(R.id.mySpinner);

        adapter2 = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, recipeNameArr);
        scrollView.scrollTo(0, 100);

        myAdapter = ArrayAdapter.createFromResource(this, R.array.recipes, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter3 = new ArrayAdapter<CharSequence>(this, R.layout.spinner_item, recipeNameArr);

        mySpinner.setAdapter(adapter3);
        recipeNameTV.setText(recipeNameArr[0]);
        recipeImg.setImageResource(recipeImgArr[0]);
        recipeIngredientTV.setText(recipeIngredientsArr[0]);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                recipeNameTV.setText(recipeNameArr[i]);
                recipeImg.setImageResource(recipeImgArr[i]);
                recipeIngredientTV.setText(recipeIngredientsArr[i]);
                scrollView.scrollTo(0, 100);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
