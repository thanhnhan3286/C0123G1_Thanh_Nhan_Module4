package com.example.ungdungmuonsach.controller;

import com.example.ungdungmuonsach.model.Book;
import com.example.ungdungmuonsach.model.BorrowBook;
import com.example.ungdungmuonsach.service.IBookService;
import com.example.ungdungmuonsach.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BorrowBookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBookService borrowBookService;

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("bookList",bookService.findAll());
        return "/list";
    }
    @GetMapping("/borrow")
    public String listBorrow(Model model){
        model.addAttribute("borrowBookList",borrowBookService.findAll());
        return "/listBorrowBook";
    }
    @GetMapping("/{id}/{quantity}/borrow")
    public String borrow(Model model, @PathVariable int id, @PathVariable int quantity){
        if(quantity <= 0){
            return "/errorQuantity";
        }else {
            String codeBorrow = bookService.ramdomCodeBorrow();
            BorrowBook borrowBook = new BorrowBook(bookService.findById(id),codeBorrow);
            this.borrowBookService.save(borrowBook);
            this.bookService.saveBookBorrow(bookService.findById(id));
            model.addAttribute("codeBorrow",codeBorrow);
            return "/codeBorrow";
        }
    }
    @PostMapping("/search")
    public String search(Model model, @RequestParam String codeBorrow){
        boolean check = borrowBookService.findAllByCodeBorrow(codeBorrow);
        if(check){
            BorrowBook borrowBook = borrowBookService.findByCodeBorrow(codeBorrow);
            Book book = bookService.findById(borrowBook.getBook().getId());
            this.bookService.saveBookReturn(book);
            this.borrowBookService.delete(borrowBook);
            model.addAttribute("book",book);
            return "/giveBack";
        }else {
            return "/errorCodeBorrow";
        }
    }
}
