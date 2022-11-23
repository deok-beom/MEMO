package Miniproject2.src;

import Miniproject2.src.presentation.KOR_UI;
import Miniproject2.src.presentation.UI;
import Miniproject2.src.data.UserRepository;

public class App {
    public static void main(String[] args) {
        UI ui = new KOR_UI();
        UserRepository userRepository = new UserRepository();

        while(true) {
            ui.start(userRepository);
        }
    }
}