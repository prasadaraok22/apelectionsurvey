function dynamicdropdown(listindex)
{
    switch (listindex)
    {
        case "east" :
            document.getElementById("status").options[0]=new Option("Select Consistency","");
            document.getElementById("status").options[1]=new Option("Rajamundry","rjy");
            document.getElementById("status").options[2]=new Option("Amalapuram","Amalapuram");
            document.getElementById("status").options[3]=new Option("Anaparthy","Anaparthy");
            document.getElementById("status").options[4]=new Option("Gannavaram","Gannavaram");
            document.getElementById("status").options[5]=new Option("Jaggampeta","Jaggampeta");
            document.getElementById("status").options[6]=new Option("Kakinada City","Kakinada City");
            document.getElementById("status").options[7]=new Option("Kakinada Rural","Kakinada Rural");
            document.getElementById("status").options[8]=new Option("Kothapeta","Kothapeta");
            document.getElementById("status").options[9]=new Option("Mandapeta","Mandapeta");
            document.getElementById("status").options[10]=new Option("Mummidivaram","Mummidivaram");
            break;

        case "west" :
            document.getElementById("status").options[0]=new Option("Select Consistency","");
            document.getElementById("status").options[1]=new Option("Achanta","Achanta");
            document.getElementById("status").options[2]=new Option("Bhimavaram","Bhimavaram");
            document.getElementById("status").options[3]=new Option("Chintalapudi","Chintalapudi");
            document.getElementById("status").options[4]=new Option("Denduluru","Denduluru");
            document.getElementById("status").options[5]=new Option("Eluru","Eluru");
            document.getElementById("status").options[6]=new Option("Gopalapuram","Gopalapuram");
            document.getElementById("status").options[7]=new Option("Kovvur","Kovvur");
            document.getElementById("status").options[8]=new Option("Narasapuram","Narasapuram");
            document.getElementById("status").options[9]=new Option("Nidadavole","Nidadavole");
            document.getElementById("status").options[10]=new Option("Palakollu","Palakollu");
            break;

        case "guntur" :
            document.getElementById("status").options[0]=new Option("Select Consistency","");
            document.getElementById("status").options[1]=new Option("Bapatla","Bapatla");
            document.getElementById("status").options[2]=new Option("Chilakaluripet","Chilakaluripet");
            document.getElementById("status").options[3]=new Option("Macherla","Macherla");
            document.getElementById("status").options[4]=new Option("Mangalagiri","Mangalagiri");
            document.getElementById("status").options[5]=new Option("Narasaraopet","Narasaraopet");
            document.getElementById("status").options[6]=new Option("Pedakurapadu","Pedakurapadu");
            document.getElementById("status").options[7]=new Option("Ponnur","Ponnur");
            document.getElementById("status").options[8]=new Option("Prathipadu","Prathipadu");
            document.getElementById("status").options[9]=new Option("Repalle","Repalle");
            document.getElementById("status").options[10]=new Option("Sattenapalle","Sattenapalle");
            break;

        case "krishna" :
            document.getElementById("status").options[0]=new Option("Select Consistency","");
            document.getElementById("status").options[1]=new Option("Avanigadda","Avanigadda");
            document.getElementById("status").options[2]=new Option("Gannavaram","Gannavaram");
            document.getElementById("status").options[3]=new Option("Gudivada","Gudivada");
            document.getElementById("status").options[4]=new Option("Jaggayyapeta","Jaggayyapeta");
            document.getElementById("status").options[5]=new Option("Kaikalur","Kaikalur");
            document.getElementById("status").options[6]=new Option("Machilipatnam","Machilipatnam");
            document.getElementById("status").options[7]=new Option("Mylavaram","Mylavaram");
            document.getElementById("status").options[8]=new Option("Nandigama","Nandigama");
            document.getElementById("status").options[9]=new Option("Nuzvid","Nuzvid");
            document.getElementById("status").options[10]=new Option("Pamarru","Pamarru");
            break;
}
return true;
}
