package app.blog;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/blog")
public class BlogService {
    private BlogRepository blogRepository;

//    @RequestMapping("/list")
//    public Page list() {
//
//    }
}
