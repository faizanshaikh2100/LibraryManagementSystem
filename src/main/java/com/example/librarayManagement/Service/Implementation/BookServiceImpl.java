package com.example.librarayManagement.Service.Implementation;

import com.example.librarayManagement.DTO.RequestDTO.BookDTO.BookRequestDTO;
import com.example.librarayManagement.DTO.ResponseDTO.BookResponseDTO;
import com.example.librarayManagement.Entity.Author;
import com.example.librarayManagement.Entity.Book;

import com.example.librarayManagement.Repositroy.AuthorRepository;
import com.example.librarayManagement.Repositroy.BookRepository;
import com.example.librarayManagement.Repositroy.CardRespositroy;
import com.example.librarayManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CardRespositroy cardRespositroy;
    @Autowired
    BookRepository bookRepository;
    @Override
    public String addBook(BookRequestDTO bookRequestDTO) throws Exception {

        try{
            Author author = authorRepository.findById(bookRequestDTO.getAuthorId()).get();
            Book book = new Book();
            book.setBookName(bookRequestDTO.getBookName());
            book.setGenre(bookRequestDTO.getGenre());
            book.setPrice(bookRequestDTO.getPrice());
            author.getBooksList().add(book);
            book.setAuthor(author);
            bookRepository.save(book);
            return "Successfully added the book ✅";
        }catch(Exception e){
           return e.getMessage();
        }

    }

    @Override
    public BookResponseDTO getBookByBookName(String name) throws Exception {
        try{
            Book book = bookRepository.findByBookName(name);
            BookResponseDTO bookResponseDTO = new BookResponseDTO(book.getBookName(),book.getIssuedDate(),book.getGenre(),book.getPrice());

            return bookResponseDTO;
        }
        catch(Exception e){
            throw new Exception("Book Not Found!😢");
        }
    }

    @Override
    public List<BookResponseDTO> getBooksByAuthorName(String name) throws Exception {
        try{
            List<Book> bookList = bookRepository.findAll();
            List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
            for(Book book:bookList){
                if(book.getAuthor().getName().equals(name)) {
                    BookResponseDTO bookResponseDTO = new BookResponseDTO(book.getBookName(), book.getIssuedDate(), book.getGenre(), book.getPrice());
                    bookResponseDTOList.add(bookResponseDTO);
                }
            }

            return bookResponseDTOList;
        }
        catch(Exception e){
            throw new Exception("Author Not Found!😢");
        }
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<BookResponseDTO> bookResponseDTOList= new ArrayList<>();

        List<Book>bookList = bookRepository.findAll();

        for(Book book:bookList){
            BookResponseDTO bookResponseDTO = new BookResponseDTO(book.getBookName(),book.getIssuedDate(),book.getGenre(),book.getPrice());
            bookResponseDTOList.add(bookResponseDTO);
        }
        return bookResponseDTOList;
    }

    @Override
    public String deleteBookByName(String name) throws Exception {
        try{
            Book book = bookRepository.findByBookName(name);
            bookRepository.delete(book);
        }
        catch (Exception e){
            throw new Exception("Book with that name not found");
        }
        return "Successfully deleted the book";
    }

//    @Override
//    public String deleteBookByName(String name) throws Exception {
//        try{
//          bookRepository.deleteByBookName(name);
//        }catch (Exception e){
//            e.getMessage();
//        }
//        return "Successfully deleted book";
//    }
}
