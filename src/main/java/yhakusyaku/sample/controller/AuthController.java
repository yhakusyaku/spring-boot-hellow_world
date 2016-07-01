package yhakusyaku.sample.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/login")
	public String login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//匿名ユーザーの場合は、ログインページ
		if (authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		//その他の場合はトップページへリダイレクト
		//ログインページからアクセスしてきた場合の対応
		else {
			return "redirect:";
		}
	}

}
