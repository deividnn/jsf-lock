# estrategia de concorrencia
<br/><br/>
jsf 2.2.9<br/>
primfaces 5.1<br/>
hibernate orm 4.3.8<br/>
hibernate validator 5.1.3<br/>
postgresql 9.3<br/>
tomcat 8.0.15<br/>
netbeans 8.2<br/>
<br/><br/>
projeto que usa a anotacao @Version do jpa<br/>
para verificar se o registro esta atualizado antes <br/>
de atualizar, mostrando mensagens caso:<br/>
-o registro atual for de uma versao anterior<br/>
-o registro foi excluido por outra transacao<br/>
