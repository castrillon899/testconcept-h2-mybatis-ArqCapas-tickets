package com.goldenrace.ticket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class TicketTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void generarTicketYConsultarloRetornaIdTicket() throws Exception {

        MvcResult resultadoLibroPrestado = mvc.perform(
                MockMvcRequestBuilders.post("/ticket/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                        		"{\r\n"
                        		+ "\r\n"
                        		+ " \"ticket\": {\r\n"
                        		+ "       \r\n"
                        		+ "        \"creationDate\": \"2021-10-06T05:00:00.000+0000\",\r\n"
                        		+ "        \"amount\": 12.0,\r\n"
                        		+ "        \"ticketDetail\": [\r\n"
                        		+ "            {\r\n"
                        		+ "             \r\n"
                        		+ "                \"description\": \"San Francisco cccc\",\r\n"
                        		+ "                \"amount\": 11.0\r\n"
                        		+ "            }\r\n"
                        		+ "            ,\r\n"
                        		+ "             {\r\n"
                        		+ "               \r\n"
                        		+ "                \"description\": \"San Francisco cccc\",\r\n"
                        		+ "                \"amount\": 1.0\r\n"
                        		+ "            }\r\n"
                        		+ "        ]\r\n"
                        		+ "    }\r\n"
                        		+ "\r\n"
                        		+ "}\r\n"
                        		+ ""
                        		
                        		))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idTicket").exists())
                .andReturn();


        ResultadoTicketTest resultadoTicket = objectMapper.readValue(resultadoLibroPrestado.getResponse().getContentAsString(), ResultadoTicketTest.class);

     ;


        mvc.perform(MockMvcRequestBuilders
                .get("/ticket/getTicketById?id=" + resultadoTicket.getIdTicket())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ticket").exists())
                .andReturn();
            


    }
    
    
    @Test
    public void intentarCrearUnTicketConValorDeTicketDiferenteALosDetallesRetornaExcepcion() throws Exception {

       mvc.perform(
                MockMvcRequestBuilders.post("/ticket/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                        		"{\r\n"
                        		+ "\r\n"
                        		+ " \"ticket\": {\r\n"
                        		+ "       \r\n"
                        		+ "        \"creationDate\": \"2021-10-06T05:00:00.000+0000\",\r\n"
                        		+ "        \"amount\": 20.0,\r\n"
                        		+ "        \"ticketDetail\": [\r\n"
                        		+ "            {\r\n"
                        		+ "             \r\n"
                        		+ "                \"description\": \"San Francisco cccc\",\r\n"
                        		+ "                \"amount\": 11.0\r\n"
                        		+ "            }\r\n"
                        		+ "            ,\r\n"
                        		+ "             {\r\n"
                        		+ "               \r\n"
                        		+ "                \"description\": \"San Francisco cccc\",\r\n"
                        		+ "                \"amount\": 1.0\r\n"
                        		+ "            }\r\n"
                        		+ "        ]\r\n"
                        		+ "    }\r\n"
                        		+ "\r\n"
                        		+ "}\r\n"
                        		+ ""
                        		
                        		))
                .andExpect(status().is4xxClientError())
                .andReturn();
    }
    
    
    @Test
    public void intentarCrearUnTicketSinEnviarParametrosObligatorioRetornaExcepcion() throws Exception {

        mvc.perform(
                MockMvcRequestBuilders.post("/ticket/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                        		"{\r\n"
                        		+ "\r\n"
                        		+ " \"ticket\": {\r\n"
                        		+ "       \r\n"
                        		+ "        \"creationDate\": \"2021-10-06T05:00:00.000+0000\",\r\n"
                          		+ "        \"ticketDetail\": [\r\n"
                        		+ "            {\r\n"
                        		+ "             \r\n"
                        		+ "                \"description\": \"San Francisco cccc\",\r\n"
                        		+ "                \"amount\": 11.0\r\n"
                        		+ "            }\r\n"
                        		+ "            ,\r\n"
                        		+ "             {\r\n"
                        		+ "               \r\n"
                        		+ "                \"description\": \"San Francisco cccc\",\r\n"
                        		+ "                \"amount\": 1.0\r\n"
                        		+ "            }\r\n"
                        		+ "        ]\r\n"
                        		+ "    }\r\n"
                        		+ "\r\n"
                        		+ "}\r\n"
                        		+ ""
                        		
                        		))
                .andExpect(status().is4xxClientError())
                .andReturn();

    }

}
