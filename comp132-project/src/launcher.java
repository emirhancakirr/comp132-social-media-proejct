/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from
anyone else. The effort in the project thus belongs completely to me. I did not search for a
solution, or I did not consult to any program written by others or did not copy any program from
other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Emirhan Cakir, 76409>
************************************************************************************************************/

/**
 * 
 * This class is made to launch program. You can initialize users,contents by
 * default To create default users,contents follow related class steps.
 * 
 * @Emirhan Cakir
 * 
 */
	public class launcher {

	public static void main(String[] args) {



		User emirhan = new User("", "", "Emirhan", "Çakır", "alsdm@gmail.com", "100x100yetgen.png", "baksetbol,tennis",
				true, 20);
		User sheldon = new User("sheldoonCopper", "sheldon123", "Sheldoon", "Cooper", "sheldoon@gmail.com",
				"sheldon.png", "pyhsich,boardgame", true, 30);
		User howard = new User("howardWolowitz", "howard123", "Howard", "Wolowitz", "howard@gmail.com", "howard.png",
				"music,astronomy", false, 30);

		User ee = new User("ee", "ee123", "Erhan", "Erkut", "ee@yetkingencler.com", "ee.png", "musici,swimming", true,
				64);

		User leonard = new User("leonard", "leonard123", "Leonard", "Hofstader", "leonard@gmail.com", "leonard.png",
				"music,pyhsich", true, 25);
		User penny = new User("penny", "penny123", "Penny", "", "penny@gmail.com", "penny.png", "film,music", false,
				25);
		User raj = new User("raj", "", "Raj", "Koothrappali", "raj@gmail.com", "raj.png", "astronomy,cooking", false,
				25);
		User ammy = new User("ammy", "ammy123", "Ammy", "Farrah Fowler", "ammy@gmail.com", "ammy.png", "biology,arph",
				false, 25);
		User yilmaz = new User("yılmaz", "yılmaz123", "Yılmaz", "", "yılmaz@exxen.com", "yılmaz.png", "Cha,cosplay",
				true, 25);
		User ilkkan = new User("ilkkan", "ilkkan123", "İlkkan", "", "ilkkan@exxen.com", "ilkkan.png", "Cha Cha", false,
				25);
		User ersoy = new User("ersoy", "ersoy123", "Ersoy", "", "ersoy@exxen.com", "ersoy.png", "cosplay", false, 25);
		User ersoysGrandmother = new User("ersoygrandmother", "ersoygrandmother123", "Ersoy's", "Grandmother",
				"ersoygrandmother@exxen.com", "100x100 user1.png", "music", false, 50);

		emirhan.follow(ee);
		emirhan.follow(yilmaz);
		emirhan.follow(leonard);

		ee.follow(sheldon);
		ee.follow(emirhan);
		ee.follow(sheldon);

		leonard.follow(sheldon);
		leonard.follow(penny);
		leonard.follow(raj);

		penny.follow(leonard);
		penny.follow(sheldon);
		penny.follow(ammy);

		raj.follow(sheldon);
		raj.follow(leonard);
		raj.follow(howard);

		ammy.follow(sheldon);
		ammy.follow(leonard);
		ammy.follow(howard);

		howard.follow(ammy);
		howard.follow(penny);
		howard.follow(leonard);

		yilmaz.follow(ilkkan);
		yilmaz.follow(ersoy);
		yilmaz.follow(ersoysGrandmother);

		ilkkan.follow(yilmaz);
		ilkkan.follow(ersoy);
		ilkkan.follow(ersoysGrandmother);

		ersoy.follow(ilkkan);
		ersoy.follow(ersoysGrandmother);
		ersoy.follow(yilmaz);

		ersoysGrandmother.follow(ersoy);
		ersoysGrandmother.follow(ee);
		ersoysGrandmother.follow(sheldon);

		Group pyhsicLover = new Group("Pyhsich Lovers", "USA", "Music,Pyhsic", sheldon);
		Group musicLover = new Group("Music Lovers", "USA", "Music,Rock,Metal", emirhan);
		Group filmLovers = new Group("Film Lovers", "Turkey", "films", leonard);
		Group F1Lovers = new Group("F1 Lovers", "USA", "F1", ee);


		Content emirhancontent1 = new Content("Lorem ispsum ,", "What a sound.....", "Music Lovers", emirhan);
		Content emirhancontent2 = new Content("dolor amet", "Emirhan Çakır",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam placerat ullamcorper augue, elementum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus. Duis risus sapien, vulputate ac lorem in, egestas egestas sapien. Mauris faucibus velit eu turpis aliquam sagittis. Cras rutrum fermentum ex, sit amet vehicula sem ultrices vitae. Vestibulum viverra vehicula sapien. Ut maximus risus lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fermentum sem mollis pulvinar. Interdum et malesuada fames ac ante ipsum primis in faucibus.",
				"My Profile", emirhan);
		Content emirhancontent3 = new Content("YetGenn",
				"I was leader at Yetkin Gençler. What a nice term and experiment for me", "100x100yetgen.png",
				"My Profile", emirhan);
		Content emirhancontent4 = new Content("F1 Racee",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam placerat ullamcorper augue, elementum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus. Duis risus sapien, vulputate ac lorem in, egestas egestas sapien. Mauris faucibus velit eu turpis aliquam sagittis. Cras rutrum fermentum ex, sit amet vehicula sem ultrices vitae. Vestibulum viverra vehicula sapien. Ut maximus risus lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fermentum sem mollis pulvinar. Interdum et malesuada fames ac ante ipsum primis in faucibus.\r\n",
				"100x100yetgen.png", "F1 Lovers", emirhan);

		emirhan.attendGroup(pyhsicLover);
		emirhan.attendGroup(musicLover);
		emirhan.attendGroup(F1Lovers);
		emirhan.attendGroup(filmLovers);

		Content leonardContent1 = new Content("Pyhsicc",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam placerat ullamcorper augue, elementum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus. Duis risus sapien, vulputate ac lorem in, egestas egestas sapien. Mauris faucibus velit eu turpis aliquam sagittis. Cras rutrum fermentum ex, sit amet vehicula sem ultrices vitae. Vestibulum viverra vehicula sapien. Ut maximus risus lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fermentum sem mollis pulvinar. Interdum et malesuada fames ac ante ipsum primis in faucibus.\r\n",
				"100x100yetgen.png", "Pyhsich Lovers", leonard);

		Content leonardContent2 = new Content("musicc",
				"\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
				"Music Lover", leonard);

		Content leonardContent3 = new Content("is ngulla tinhcid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", leonard);
		Content leonardContent4 = new Content("nuldgla",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Pyhsich Lover", leonard);
		Content leonardContent5 = new Content("porsro", "la tincidunt ac. Don", "My Profile", leonard);
		leonard.attendGroup(musicLover);
		leonard.attendGroup(pyhsicLover);

		Content sheldonContent1 = new Content("akhsayu", "la tincidunt ac. Don", "My Profile", sheldon);
		Content sheldonContent4 = new Content("nulssasaa",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Pyhsich Lover", sheldon);
		Content sheldonContent2 = new Content("ids  tidncid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", sheldon);
		Content sheldonContent3 = new Content("ids cid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", sheldon);
		Content sheldonContent5 = new Content("pordadro", "la tincidunt ", "My Profile", sheldon);

		sheldon.attendGroup(pyhsicLover);
		sheldon.attendGroup(F1Lovers);

		Content pennyContent1 = new Content("akhdhg ayu", "la tinkasd fcidunt ac. Don", "Film Lovers", penny);
		Content pennyContent2 = new Content("is  tindcid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "Film Lovers", penny);
		Content pennyContent3 = new Content("isdt adc. Doid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", penny);
		Content pennyContent4 = new Content("nulasdfasasaa",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Music Lover", sheldon);
		Content pennyContent5 = new Content("podradro", "la tincidunt ", "My Profile", penny);

		penny.attendGroup(filmLovers);
		penny.attendGroup(musicLover);

		Content rajContent1 = new Content("akhadsfdayu", "la tincidunt ac. Don", "My Profile", raj);
		Content rajContent4 = new Content("nulsadsfasaa",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Pyhsich Lover", raj);
		Content rajContent2 = new Content("isfinisbuscid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", raj);
		Content rajContent3 = new Content("icidudnt ac. Doneid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", raj);
		Content rajContent5 = new Content("porasdsdrso", "cidunt ac. Donencidunt ", "My Profile", raj);

		raj.attendGroup(pyhsicLover);
		raj.attendGroup(F1Lovers);

		Content ammyContent1 = new Content("akhdhg ayu", "la tinkasd fcidunt ac. Don", "Film Lovers", ammy);
		Content ammyContent2 = new Content("is  tincid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "Film Lovers", ammy);
		Content ammyContent3 = new Content("isdadf cid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", ammy);
		Content ammyContent4 = new Content("nulasdfaasasaa",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Music Lover", ammy);
		Content ammyContent5 = new Content("poradro", "la tincidunt ", "My Profile", ammy);

		ammy.attendGroup(filmLovers);
		ammy.attendGroup(musicLover);

		Content howardContent1 = new Content("akhadsffayu", "la tincidunt ac. Don", "My Profile", howard);
		Content howardContent4 = new Content("nulsadsfasaa",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Pyhsich Lover", howard);
		Content howardContent2 = new Content("isss  tincid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", howard);
		Content howardContent3 = new Content("iss ddcid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", howard);
		Content howardContent5 = new Content("porasdssdro", "la tincidunt ", "My Profile", howard);

		howard.attendGroup(pyhsicLover);
		howard.attendGroup(musicLover);

		Content eecontent1 = new Content("Losrem ipsum ,", "What a sound.....", "Music Lovers", ee);
		Content eecontent2 = new Content("dolsor sit amet",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam placerat ullamcorper augue, elementum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus. Duis risus sapien, vulputate ac lorem in, egestas egestas sapien. Mauris faucibus velit eu turpis aliquam sagittis. Cras rutrum fermentum ex, sit amet vehicula sem ultrices vitae. Vestibulum viverra vehicula sapien. Ut maximus risus lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fermentum sem mollis pulvinar. Interdum et malesuada fames ac ante ipsum primis in faucibus.",
				"My Profile", ee);
		Content eecontent3 = new Content("nsssectetu",
				"posuere cubilia curae; Alnsectetul nulla suscipit quam auctor consequat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In euismod placerat metus id fermentum. Integer a mi tellus. Praesent interdum dapibus velit, nec tincidunt lorem posuere et.",
				"dune.jpg", "My Profile", ee);
		Content eecontent4 = new Content("nsasectetu",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam placerat ullamcorper augue, elementum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus. Duis risus sapien, vulputate ac lorem in, egestas egestas sapien. Mauris faucibus velit eu turpis aliquam sagittis. Cras rutrum fermentum ex, sit amet vehicula sem ultrices vitae. Vestibulum viverra vehicula sapien. Ut maximus risus lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fermentum sem mollis pulvinar. Interdum et malesuada fames ac ante ipsum primis in faucibus.\r\n",
				"100x100yetgen.png", "F1 Lovers", ee);

		ee.attendGroup(pyhsicLover);
		ee.attendGroup(musicLover);
		ee.attendGroup(F1Lovers);
		ee.attendGroup(filmLovers);

		Content yilmazcontent1 = new Content("Lorem ipsu", "What a sound.....", "Music Lovers", yilmaz);
		Content yilmazcontent2 = new Content("dolor sit amet", "Emirhan Çakır",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam placerat ullamcorper augue, elementum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus. Duis risus sapien, vulputate ac lorem in, egestas egestas sapien. Mauris faucibus velit eu turpis aliquam sagittis. Cras rutrum fermentum ex, sit amet vehicula sem ultrices vitae. Vestibulum viverra vehicula sapien. Ut maximus risus lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fermentum sem mollis pulvinar. Interdum et malesuada fames ac ante ipsum primis in faucibus.",
				"My Profile", yilmaz);
		Content yilmazcontent3 = new Content("yetemte",
				"posuere cubilia curae; Aliquam vel nulla suscipit quam auctor consequat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In euismod placerat metus id fermentum. Integer a mi tellus. Praesent interdum dapibus velit, nec tincidunt lorem posuere et.",
				"dune.jpg", "My Profile", yilmaz);
		Content yilmazcontent4 = new Content("FsadfRace",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam placerat ullamcorper augue, elementum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus. Duis risus sapien, vulputate ac lorem in, egestas egestas sapien. Mauris faucibus velit eu turpis aliquam sagittis. Cras rutrum fermentum ex, sit amet vehicula sem ultrices vitae. Vestibulum viverra vehicula sapien. Ut maximus risus lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fermentum sem mollis pulvinar. Interdum et malesuada fames ac ante ipsum primis in faucibus.\r\n",
				"100x100yetgen.png", "F1 Lovers", yilmaz);

		yilmaz.attendGroup(pyhsicLover);
		yilmaz.attendGroup(musicLover);
		yilmaz.attendGroup(F1Lovers);
		yilmaz.attendGroup(filmLovers);

		Content ilkkanContent1 = new Content("la diam, elementum", "la tincidunt ac. Don", "My Profile", ilkkan);
		Content ilkkanContent2 = new Content(". Vivamus",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Pyhsich Lover", ilkkan);
		Content ilkkanContent3 = new Content("isssds  c id sem eget ",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", ilkkan);
		Content ilkkanContent4 = new Content("is dsdfdcid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", ilkkan);

		ilkkan.attendGroup(pyhsicLover);
		ilkkan.attendGroup(musicLover);

		Content ersoyContent1 = new Content("adsfayu", "la tincidunt ac. Don", "My Profile", ersoy);
		Content ersoyContent2 = new Content("nulsasddsfasaa",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Pyhsich Lover", ersoy);
		Content ersoyContent3 = new Content("adfss  tincid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", ersoy);
		Content ersoyContent4 = new Content("is sdaddcid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", ersoy);

		ersoy.attendGroup(pyhsicLover);
		ersoy.attendGroup(musicLover);

		Content ersoysgranmotherContent1 = new Content("akhadssddsfayu", "la tincidunt ac. Don", "My Profile",
				ersoysGrandmother);
		Content ersoysgranmotherContent2 = new Content("nulsadsfasaa",
				"lacus, quis aliquam mauris finibus ut. Vivamus nulla diam, elementum sit amet lorem ac, interdum sagittis ligula. Aliquam vel porta massa. Sed ultrices urna fer",
				"faraday.jpg", "Pyhsich Lover", ersoysGrandmother);
		Content ersoysgranmotherContent3 = new Content("issdsds  tincid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", ersoysGrandmother);
		Content ersoysgranmotherContent4 = new Content("issad ddcid",
				"mentum mollis nulla tincidunt ac. Donec id sem eget nulla tristique dapibus. Curabitur in viverra purus. Nunc laoreet ut mauris sit amet efficitur. Fusce vel felis a nisl rhoncus molestie. Vivamus ut volutpat lacus.",
				"dune.jpg", "My Profile", ersoysGrandmother);

		ersoysGrandmother.attendGroup(pyhsicLover);
		ersoysGrandmother.attendGroup(musicLover);

		LoginPage loginstart = new LoginPage();
	}

}