# estrategia de concorrencia
<br/><br/>
jsf 2.2.9<br/>
hibernate 4.3.8<br/>
postgresql 9.3<br/>
tomca 8.0.15<br/>
<br/><br/>
projeto que usa a anotacao @Version do jpa<br/>
para verificar se o registro esta atualizado antes <br/>
de atualizar, mostrando mensagens caso:<br/>
-o registro atual for de uma versao anterior<br/>
-o registro foi excluido por outra transacao<br/>
