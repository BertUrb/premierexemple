package com.mjcdouai.premierexemble.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mjcdouai.premierexemble.R;
import com.mjcdouai.premierexemble.model.CustomAdapter;
import com.mjcdouai.premierexemble.model.FootballPlayer;

import java.net.URL;
import java.util.ArrayList;

public class LoggedInScreen extends AppCompatActivity implements CustomAdapter.ViewHolder.onPlayerListener {

    private TextView mWelcomeText;
    private RecyclerView mPlayerListRecyclerView;
    private ArrayList<FootballPlayer> mFootballPlayerArrayList = new ArrayList<>();
    private CustomAdapter CustomAd;
    private LinearLayoutManager mRecentLayoutManager;

    public static final String MESSAGE_URL = "com.mjcdouai.premierexemble.controller.url";
    public static final String MESSAGE_NAME = "com.mjcdouai.premierexemble.controller.name";
    public static final String MESSAGE_DESC = "com.mjcdouai.premierexemble.controller.desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);

        Intent intent = getIntent();


        mWelcomeText = findViewById(R.id.textView2);
        mPlayerListRecyclerView = findViewById(R.id.player_list);

        String text = getString(R.string.welcome_messages, intent.getStringExtra(MainActivity.sMESSAGE));

        mWelcomeText.setText(text  );

        String desc1 = "Keilor Antonio Navas Gamboa, dit Keylor Navas, né le 15 décembre 1986 à San Isidro de El General, est un footballeur international costaricien évoluant au poste de gardien de but au Paris Saint-Germain. Il possède également la nationalité espagnole depuis 2014.\n" +
                "\n" +
                "Il fait ses débuts professionnels en 2005 avec le club costaricain du Deportivo Saprissa où il reste jusqu'en 2010, remportant cinq championnats costaricain et une Ligue des champions de la CONCACAF en 2005. Il rejoint ensuite le club espagnol de deuxième division Albacete Balompié, qui termine relégué au terme de la saison 2010-2011. Il rejoint ensuite le Levante Unión Deportiva, d'abord sous forme de prêt en juillet 2011 puis de manière définitive un an plus tard. Il y remporte notamment le prix de joueur du mois du championnat d'Espagne de janvier 2014 ainsi que le prix LFP de meilleur gardien pour la saison 2013-2014. Ses performances en championnat couplées à une Coupe du monde 2014 très remarquée lui permettent d'obtenir un transfert au Real Madrid en août 2014, où il a été le gardien titulaire depuis le départ d'Iker Casillas en juillet 2015. Il remporte trois Ligues des champions avec le Real. Début septembre 2019, il est transféré au Paris Saint-Germain, alors qu'Alphonse Areola fait le chemin inverse en rejoignant le Real.\n" +
                "\n" +
                "Il a actuellement 92 sélections avec le Costa Rica. Sa première sélection date d'octobre 2008. Il prend par la suite part aux Gold Cup 2009, dont il finit meilleur gardien, et 2013. Il participe également à la Coupe du monde 2014, où ses performances, permettant notamment à sa sélection d'atteindre les quarts de finale, lui valent d'être élu deuxième meilleur gardien de la compétition derrière l'Allemand Manuel Neuer. Il est qualifié avec son équipe nationale pour la Coupe du monde 2018 en Russie.",
                desc2 ="Achraf Hakimi (en tamazight: ⴰⵛⵕⴰⴼ ⵃⴰⴽⵉⵎⵉ), né le 4 novembre 1998 à Madrid en Espagne, est un footballeur international marocain évoluant au poste d'arrière droit au Paris Saint-Germain.\n" +
                        "\n" +
                        "Formé au Real Madrid, il participe à l'UEFA Youth League lors des saisons 2015-2016 et 2016-20173. Lors de la saison suivante, Achraf Hakimi remporte la Ligue des champions 2017-2018 avec l'équipe première du Real Madrid. Ensuite, il est prêté pendant deux saisons au Borussia Dortmund avant de signer un contrat définitif avec l'Inter Milan, club dans lequel il se révèle en remportant la Serie A en 2021. Le 6 juillet 2021, son transfert au Paris Saint-Germain est officialisé.\n" +
                        "\n" +
                        "À l'âge de dix-sept ans, il choisit de jouer en faveur de la sélection marocaine aux dépens de l'équipe nationale d'Espagne4. Avec celle-ci, il participe à la Coupe du monde 2018, compétition où il est le troisième plus jeune joueur derrière Daniel Arzani et Kylian Mbappé. Il dispute également la CAN 2019, y atteignant les huitièmes de finales.",
                desc3 ="Presnel Kimpembe (prononcé en français : [pʁɛsnɛl kimpɛmbe]), né le 13 août 1995 à Beaumont-sur-Oise, dans le Val-d'Oise, en France, est un footballeur international français, évoluant actuellement au poste de défenseur central au Paris Saint-Germain.\n" +
                        "\n" +
                        "Il remporte la Coupe du monde 2018 avec l'équipe de France, alors qu'il est remplaçant de la charnière Samuel Umtiti et Raphaël Varane. En 2021, il remporte aussi la Ligue des Nations 2020 avec l’équipe de France, reportée au moins d’octobre de l’année suivante en raison de la crise sanitaire du Coronavirus.",
                desc4 = "Sergio Ramos García, né le 30 mars 1986 à Camas en Andalousie, est un footballeur international espagnol qui évolue au poste de défenseur central au Paris Saint-Germain.\n" +
                        "\n" +
                        "Il effectue l'essentiel de sa carrière au Real Madrid et avec l'équipe d'Espagne au poste de défenseur central ou de latéral lors de ses débuts à Séville et à Madrid.\n" +
                        "\n" +
                        "Sous le maillot de sa sélection nationale, il remporte l'Euro 2008, la Coupe du monde 2010 et l'Euro 2012 en tant que titulaire, faisant donc partie des sept joueurs présents sur le terrain lors de ces trois finales remportées consécutivement pour une triple couronne inédite dans l'histoire du football mondial. Il est par ailleurs actuellement le joueur le plus capé de la sélection espagnole devant Iker Casillas.\n" +
                        "\n" +
                        "Il devient le capitaine du Real Madrid et de l'Espagne, récupérant le brassard de capitaine du Real Madrid lors du départ en 2015 de l’ancien capitaine et coéquipier en sélection Iker Casillas au FC Porto et le garde jusqu'à son départ en France en 2021. Le 19 juillet 2020, il entre dans l'histoire en ayant marqué 11 buts en une saison en Liga, faisant partie des rares défenseurs ayant marqué plus de 10 buts en Liga depuis Ronald Koeman en 1994 avec 11 réalisations, et le premier au xxie siècle.";
        try {
            FootballPlayer fp1 = new FootballPlayer("Keylor Navas", new URL("https://assets-fr.imgfoot.com/keylor-navas-psg-2021-604e75d5796aa.jpg"),desc1);
            mFootballPlayerArrayList.add(fp1);
            FootballPlayer fp2 = new FootballPlayer("Achraf Hakimi", new URL("https://images.psg.media/media/207372/17.jpg?"),desc2);
            mFootballPlayerArrayList.add(fp2);
            FootballPlayer fp3 = new FootballPlayer("Presnel Kimpembe", new URL("https://www.sofoot.com/IMG/joueurs/presnel-kimpembe-218649.jpg"),desc3);
            mFootballPlayerArrayList.add(fp3);
            FootballPlayer fp4 = new FootballPlayer("Sergio Ramos", new URL("https://images.psg.media/media/207467/19.jpg"),desc4);
            mFootballPlayerArrayList.add(fp4);
        }
        catch (Exception e)
        {

        }
        CustomAd = new CustomAdapter(mFootballPlayerArrayList,this);
        mPlayerListRecyclerView.setAdapter(CustomAd);
        mRecentLayoutManager = new LinearLayoutManager(this);
        mPlayerListRecyclerView.setLayoutManager(mRecentLayoutManager);
        CustomAd.notifyDataSetChanged();












    }

    @Override
    public void onPlayerClick(int position) {
        Intent PlayerDetailsIntent = new Intent(this,Player_details.class);
        PlayerDetailsIntent.putExtra(MESSAGE_NAME,mFootballPlayerArrayList.get( position).getName());
        PlayerDetailsIntent.putExtra(MESSAGE_URL,mFootballPlayerArrayList.get( position).getPhotoUrl().toString());

        PlayerDetailsIntent.putExtra(MESSAGE_DESC,mFootballPlayerArrayList.get( position).getDesc());

        startActivity(PlayerDetailsIntent);
    }
}