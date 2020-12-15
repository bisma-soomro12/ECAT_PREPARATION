package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class important_points extends AppCompatActivity {
    ImageButton back;
    RecyclerView recycle_point;
    RecyclerView.Adapter recycle_adapter_point;
    RecyclerView.LayoutManager recycle_layout;
    String points_topic[]={"Rutherford atomic model",
            "Molecular Mass",
            "Gram Molecular Mass",
            "Mole",
            "Electrolysis of Water",
            "Electronegative",
            "Volume of Triangular Prism",
            "Coulomb's Law",
            "Applications of Gauss Law"};
    String points_Discription[]={"Physicist Ernest Rutherford envisioned the atom as a miniature solar system, with electrons orbiting around a massive nucleus, and as mostly empty space, with the nucleus occupying only a very small part of the atom.",
            "The sum of the masses present in a molecule is called molecular formula",
            "The Atomic molecular mass if expressed in a grams then is called gram molecular mass",
    "The atomic mass or molecular mass of a substance if expressed in the gram is called as Mole",
    "Electrolysis of water is the process of using electricity to decompose water into oxygen and hydrogen gas. ... Sometimes called water splitting, electrolysis requires a minimum potential difference of 1.23 volts" +
            "Reduction at cathode: 2 H+(aq) + 2e− → H2(g)"+"Oxidation at anode: 2 H2O(l) → O2(g) + 4 H+(aq) + 4e−",
    "They are postive in the nature because they have low electro negativity. We know that electronegativity decreses as the no of atomic size increased",
    "area of triangle × Height = (1/2 base × height) × Height",
    "Coulomb’s law in vector form (Agreement with Newton’s third law i.e. F12 = ‒F21)",
    "In the case of a charged ring of radius R on its axis at a distance x from the centre of the ring. ...\n" +
            "In case of an infinite line of charge, at a distance 'r'. ...\n" +
            "The intensity of the electric field near a plane sheet of charge is E = σ/2ε0K where σ = surface charge density."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_points);
        getSupportActionBar().hide();
        recycle_point=(RecyclerView)findViewById(R.id.recycler_view_points);
        recycle_point.setHasFixedSize(true);
        recycle_layout= new LinearLayoutManager(this);
        recycle_point.setLayoutManager(recycle_layout);
        recycle_adapter_point=new TopicsRecyclerAdapter(this,points_topic,points_Discription);
        recycle_point.setAdapter(recycle_adapter_point);
        back=(ImageButton)findViewById(R.id.backButton2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(important_points.this,home.class);
                startActivity(intent);
            }
        });
    }
}