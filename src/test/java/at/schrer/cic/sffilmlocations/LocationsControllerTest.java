package at.schrer.cic.sffilmlocations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LocationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void unknownPath() throws Exception {

        this.mockMvc.perform(get("/thereIsNoResourceHere")).andDo(print())
                .andExpect(status().isNotFound());

    }

    @Test
    public void wrongMethod() throws Exception {

        this.mockMvc.perform(put(LocationsController.API_V1+"locations")).andDo(print())
                .andExpect(status().isMethodNotAllowed());

    }

    @Test
    public void unknownLocation() throws Exception {
        this.mockMvc.perform(get(LocationsController.API_V1+"locations").param("locations","ThisIsAnUnknownLocation")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void unknownTitle() throws Exception {
        this.mockMvc.perform(get(LocationsController.API_V1+"locations").param("title","ThisIsAnUnknownTitle")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }


}
